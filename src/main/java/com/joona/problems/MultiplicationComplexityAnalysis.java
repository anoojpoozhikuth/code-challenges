package com.joona.problems;

public class MultiplicationComplexityAnalysis {

    public int russianPeasantsAlgo(int a, int b) {
        int x = a;
        int y = b;
        int z = 0;
        while (x > 0) {
            if (x % 2 == 1) {
                z = z + y;
            }
            x = x >> 1;  // Right shift x by 1 bit (equivalent to dividing x by 2)
            y = y << 1;  // Left shift y by 1 bit (equivalent to multiplying y by 2)
        }

        System.out.println("" + a + "  * " + b + " = " + z);
        System.out.println("Time unit : " + rusrussianPeasantsUnits(a));
        return z;
    }

    double rusrussianPeasantsUnits(int n) {
        double logBase2 = Math.log(n) / Math.log(2);
        return 3 + 3 * n + logBase2 + 1;
    }
}
