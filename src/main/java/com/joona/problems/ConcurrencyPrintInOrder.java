package com.joona.problems;

import java.util.concurrent.CountDownLatch;

/**
 * Demonstrates how to execute three methods in a fixed order across three
 * separate threads using countdown latches.
 *
 * This example simulates the LeetCode "Print in Order" problem, where the
 * same object is shared by three threads and methods must execute as:
 * first() -> second() -> third().
 */

public class ConcurrencyPrintInOrder {
    @FunctionalInterface
    interface InterruptibleRunnable {
        void run() throws InterruptedException;
    }

    /**
     * Wraps an interruptible runnable inside a normal Runnable so the caller can
     * use it with Thread without propagating InterruptedException.
     *
     * If the thread is interrupted while waiting in Foo, this helper preserves
     * the interrupt state on the current thread.
     */
    private static Runnable safeRun(InterruptibleRunnable r) {
        return () -> {
            try {
                r.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // Optionally log or handle further
            }
        };
    }

    /**
     * Creates three threads in the order specified by nums and starts them.
     *
     * Thread assignment is based on the sequence values in nums, but the
     * execution order is enforced by the Foo synchronization logic.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2 };
        Foo foo = new Foo();
        Thread A = null;
        Thread B = null;
        Thread C = null;
        Runnable printFirst = () -> {
            System.out.print("First");
        };
        Runnable printSecond = () -> {
            System.out.print("Second");
        };
        Runnable printThird = () -> {
            System.out.print("Third");
        };

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                switch (nums[i]) {
                    case 1:
                        A = new Thread(safeRun(() -> foo.first(printFirst)));
                        break;
                    case 2:
                        A = new Thread(safeRun(() -> foo.second(printSecond)));
                        break;
                    case 3:
                        A = new Thread(safeRun(() -> foo.third(printThird)));
                        break;
                }
            } else if (i == 1) {
                switch (nums[i]) {
                    case 1:
                        B = new Thread(safeRun(() -> foo.first(printFirst)));
                        break;
                    case 2:
                        B = new Thread(safeRun(() -> foo.second(printSecond)));
                        break;
                    case 3:
                        B = new Thread(safeRun(() -> foo.third(printThird)));
                        break;
                }
            } else if (i == 2) {
                switch (nums[i]) {
                    case 1:
                        C = new Thread(safeRun(() -> foo.first(printFirst)));
                        break;
                    case 2:
                        C = new Thread(safeRun(() -> foo.second(printSecond)));
                        break;
                    case 3:
                        C = new Thread(safeRun(() -> foo.third(printThird)));
                        break;
                }
            }
        }

        // Start the threads
        if (A != null) A.start();
        if (B != null) B.start();
        if (C != null) C.start();

        // Wait for threads to finish
        try {
            if (A != null) A.join();
            if (B != null) B.join();
            if (C != null) C.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Foo {
    private final CountDownLatch firstDone;
    private final CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    /**
     * Executes the first action and signals that first() has completed.
     */
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstDone.countDown();
    }

    /**
     * Waits until the first action is complete, then executes the second action.
     */
    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();
        printSecond.run();
        secondDone.countDown();
    }

    /**
     * Waits until the second action is complete, then executes the third action.
     */
    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();
        printThird.run();
    }
}
