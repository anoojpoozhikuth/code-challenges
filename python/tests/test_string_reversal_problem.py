"""
Test cases for StringReversalProblem class.

Run tests with:
    pytest python/tests/test_string_reversal_problem.py -v
"""

import sys
from pathlib import Path

# Add the project root to the Python path for direct execution
project_root = Path(__file__).parent.parent
sys.path.insert(0, str(project_root))

import pytest
from problems.string_reversal_problem import StringReversalProblem

class TestStringReversalProblem:
    """Test suite for StringReversalProblem class."""

    @pytest.fixture
    def problem(self):
        """Fixture providing a StringReversalProblem instance."""
        return StringReversalProblem()

    # Tests for the primary efficient two-pointer approach
    class TestReverseStringTwoPointer:
        """Tests for the two-pointer reverse_string method."""

        def test_reverse_simple_string(self, problem):
            """Test reversing a simple string."""
            assert problem.reverse_string("hello") == "olleh"

        def test_reverse_mixed_case_string(self, problem):
            """Test reversing a mixed-case string."""
            assert problem.reverse_string("Java") == "avaJ"

        def test_reverse_single_character(self, problem):
            """Test reversing a single character."""
            assert problem.reverse_string("a") == "a"

        def test_reverse_empty_string(self, problem):
            """Test reversing an empty string."""
            assert problem.reverse_string("") == ""

        def test_reverse_none_string(self, problem):
            """Test reversing None returns None."""
            assert problem.reverse_string(None) is None

        def test_reverse_palindrome_string(self, problem):
            """Test reversing a palindrome returns the same string."""
            assert problem.reverse_string("racecar") == "racecar"

        def test_reverse_string_with_spaces(self, problem):
            """Test reversing a string with spaces."""
            assert problem.reverse_string("hello world") == "dlrow olleh"

        def test_reverse_string_with_special_characters(self, problem):
            """Test reversing a string with special characters."""
            assert problem.reverse_string("a!b@c#d$") == "$d#c@b!a"

        def test_reverse_string_with_numbers(self, problem):
            """Test reversing a string with numbers."""
            assert problem.reverse_string("abc123") == "321cba"

        def test_reverse_two_character_string(self, problem):
            """Test reversing a two-character string."""
            assert problem.reverse_string("ab") == "ba"

        def test_reverse_string_with_unicode_characters(self, problem):
            """Test reversing a string with unicode characters."""
            assert problem.reverse_string("café") == "éfac"

        def test_reverse_long_string(self, problem):
            """Test reversing a long string."""
            long_string = "The quick brown fox jumps over the lazy dog"
            expected = "god yzal eht revo spmuj xof nworb kciuq ehT"
            assert problem.reverse_string(long_string) == expected

        def test_reverse_string_with_tabs_and_newlines(self, problem):
            """Test reversing a string with whitespace characters."""
            assert problem.reverse_string("a\tb\nc") == "c\nb\ta"

        def test_reverse_string_with_repeated_characters(self, problem):
            """Test reversing a string with repeated characters."""
            assert problem.reverse_string("aabbcc") == "ccbbaa"

    # Tests for the recursive approach
    class TestReverseStringRecursive:
        """Tests for the recursive reverse_string_recursive method."""

        def test_reverse_string_recursive_simple(self, problem):
            """Test recursive reversal of a simple string."""
            assert problem.reverse_string_recursive("hello") == "olleh"

        def test_reverse_string_recursive_single_character(self, problem):
            """Test recursive reversal of a single character."""
            assert problem.reverse_string_recursive("x") == "x"

        def test_reverse_string_recursive_empty(self, problem):
            """Test recursive reversal of an empty string."""
            assert problem.reverse_string_recursive("") == ""

        def test_reverse_string_recursive_none(self, problem):
            """Test recursive reversal returns None for None input."""
            assert problem.reverse_string_recursive(None) is None

        def test_reverse_string_recursive_with_spaces(self, problem):
            """Test recursive reversal of a string with spaces."""
            assert problem.reverse_string_recursive("hello world") == "dlrow olleh"

        def test_reverse_string_recursive_long_string(self, problem):
            """Test recursive reversal of a longer string."""
            assert problem.reverse_string_recursive("programming") == "gnimmargorp"

    # Tests for the slicing approach
    class TestReverseStringSlicing:
        """Tests for the slicing reverse_string_slicing method."""

        def test_reverse_string_slicing_simple(self, problem):
            """Test slicing reversal of a simple string."""
            assert problem.reverse_string_slicing("hello") == "olleh"

        def test_reverse_string_slicing_empty(self, problem):
            """Test slicing reversal of an empty string."""
            assert problem.reverse_string_slicing("") == ""

        def test_reverse_string_slicing_none(self, problem):
            """Test slicing reversal returns None for None input."""
            assert problem.reverse_string_slicing(None) is None

        def test_reverse_string_slicing_with_special_characters(self, problem):
            """Test slicing reversal of a string with special characters."""
            assert problem.reverse_string_slicing("!@#$%^&*()") == ")(*&^%$#@!"

    # Tests for the built-in reversed approach
    class TestReverseStringBuiltIn:
        """Tests for the built-in reversed_string_using_reversed_builtin method."""

        def test_reverse_string_builtin_simple(self, problem):
            """Test built-in reversal of a simple string."""
            assert problem.reverse_string_using_reversed_builtin("hello") == "olleh"

        def test_reverse_string_builtin_empty(self, problem):
            """Test built-in reversal of an empty string."""
            assert problem.reverse_string_using_reversed_builtin("") == ""

        def test_reverse_string_builtin_none(self, problem):
            """Test built-in reversal returns None for None input."""
            assert problem.reverse_string_using_reversed_builtin(None) is None

    # Comparison tests to verify all approaches produce the same result
    class TestAllApproachesConsistency:
        """Tests verifying that all approaches produce consistent results."""

        def test_all_approaches_produce_same_result_simple(self, problem):
            """Test that all approaches produce the same result for simple string."""
            test_string = "programming"
            result1 = problem.reverse_string(test_string)
            result2 = problem.reverse_string_recursive(test_string)
            result3 = problem.reverse_string_slicing(test_string)
            result4 = problem.reverse_string_using_reversed_builtin(test_string)

            assert result1 == result2 == result3 == result4

        def test_all_approaches_produce_same_result_complex(self, problem):
            """Test that all approaches produce the same result for complex string."""
            test_string = "2024-05-06 CodeChallenge!"
            result1 = problem.reverse_string(test_string)
            result2 = problem.reverse_string_slicing(test_string)
            result3 = problem.reverse_string_using_reversed_builtin(test_string)

            assert result1 == result2 == result3
            assert result1 == "!egnellahCedoC 60-50-4202"

        def test_all_approaches_with_empty_string(self, problem):
            """Test that all approaches handle empty strings consistently."""
            result1 = problem.reverse_string("")
            result2 = problem.reverse_string_recursive("")
            result3 = problem.reverse_string_slicing("")
            result4 = problem.reverse_string_using_reversed_builtin("")

            assert result1 == result2 == result3 == result4 == ""

        def test_all_approaches_with_special_chars(self, problem):
            """Test that all approaches handle special characters consistently."""
            test_string = "test@123!#$%"
            result1 = problem.reverse_string(test_string)
            result2 = problem.reverse_string_slicing(test_string)
            result3 = problem.reverse_string_using_reversed_builtin(test_string)

            assert result1 == result2 == result3
            assert result1 == "%$#!321@tset"

    # Edge cases and performance tests
    class TestEdgeCases:
        """Tests for edge cases and boundary conditions."""

        def test_very_long_string(self, problem):
            """Test reversing a very long string."""
            long_string = "a" * 10000
            expected = "a" * 10000
            assert problem.reverse_string(long_string) == expected

        def test_long_string_with_distinct_chars(self, problem):
            """Test reversing a long string with distinct characters."""
            import string
            test_string = string.ascii_letters + string.digits + string.punctuation
            result = problem.reverse_string(test_string)
            assert result == test_string[::-1]

        def test_alternating_pattern(self, problem):
            """Test reversing a string with alternating pattern."""
            assert problem.reverse_string("ababab") == "bababa"

        def test_all_same_characters(self, problem):
            """Test reversing a string with all same characters."""
            assert problem.reverse_string("xxxxxx") == "xxxxxx"


# Pytest compatibility - standalone test execution
if __name__ == "__main__":
    pytest.main([__file__, "-v"])
