"""
String Reversal Problem

Reverse a given string without using the standard reverse function.
Solve the problem in the most efficient way in terms of time and space complexity.

Examples:
---------
>>> problem = StringReversalProblem()
>>> problem.reverse_string("hello")
'olleh'
>>> problem.reverse_string("Java")
'avaJ'
>>> problem.reverse_string("a")
'a'
>>> problem.reverse_string("")
''

Constraints:
-----------
- 0 <= string length <= 10^6
- The string can contain any printable ASCII characters

Complexity Analysis:
-------------------
Time Complexity: O(n) - We iterate through each character exactly once
Space Complexity: O(n) - Required for the output string (strings are immutable in Python)
                         Auxiliary space (excluding output): O(1) for the two pointers
"""


class StringReversalProblem:
    """
    Class containing various approaches to reverse a string efficiently.
    """

    def reverse_string(self, s: str) -> str:
        """
        Reverses a string using a two-pointer approach (most efficient).

        Approach:
        ---------
        Converts the string to a list (mutable) and uses two pointers (left and right)
        starting from opposite ends. Swaps characters at these pointers and moves them
        towards the center until they meet. This is the most efficient approach as it:
        - Uses only O(1) auxiliary space (two pointers)
        - Makes a single pass with O(n) time complexity
        - Avoids creating intermediate strings or using recursion

        Args:
        ----
        s (str): The string to be reversed. Can be None, empty, or contain any characters.

        Returns:
        -------
        str: The reversed string, or the same string if it's None or empty.

        Example:
        -------
        >>> problem = StringReversalProblem()
        >>> problem.reverse_string("hello")
        'olleh'
        >>> problem.reverse_string("hello world")
        'dlrow olleh'
        >>> problem.reverse_string(None)
        """
        # Handle None or empty strings
        if s is None or len(s) == 0:
            return s

        # Convert string to list for efficient manipulation (strings are immutable)
        chars = list(s)

        # Use two-pointer approach for in-place reversal
        left = 0
        right = len(chars) - 1

        # Swap characters from both ends moving towards the center
        while left < right:
            # Swap characters at left and right positions
            chars[left], chars[right] = chars[right], chars[left]

            # Move pointers towards center
            left += 1
            right -= 1

        # Convert list back to string and return
        return ''.join(chars)

    def reverse_string_recursive(self, s: str) -> str:
        """
        Reverses a string using recursion (less efficient in terms of space due to call stack).
        Provided for educational purposes.

        Note:
        ----
        This approach has O(n) space complexity due to the recursion call stack.

        Args:
        ----
        s (str): The string to be reversed.

        Returns:
        -------
        str: The reversed string.

        Example:
        -------
        >>> problem = StringReversalProblem()
        >>> problem.reverse_string_recursive("hello")
        'olleh'
        """
        # Base case: None or single character
        if s is None or len(s) <= 1:
            return s

        # Recursive case: last character + reverse of substring excluding last character
        return self.reverse_string_recursive(s[1:]) + s[0]

    def reverse_string_slicing(self, s: str) -> str:
        """
        Reverses a string using Python's slicing notation.
        This is concise and Pythonic but creates a new string.

        Note:
        ----
        While elegant, this method is less instructive than the two-pointer approach
        for learning about string reversal algorithms.

        Args:
        ----
        s (str): The string to be reversed.

        Returns:
        -------
        str: The reversed string.

        Example:
        -------
        >>> problem = StringReversalProblem()
        >>> problem.reverse_string_slicing("hello")
        'olleh'
        """
        if s is None:
            return None
        return s[::-1]

    def reverse_string_using_reversed_builtin(self, s: str) -> str:
        """
        Reverses a string using Python's built-in reversed() function.
        Provided for reference and comparison.

        Args:
        ----
        s (str): The string to be reversed.

        Returns:
        -------
        str: The reversed string.

        Example:
        -------
        >>> problem = StringReversalProblem()
        >>> problem.reverse_string_using_reversed_builtin("hello")
        'olleh'
        """
        if s is None:
            return None
        return ''.join(reversed(s))
