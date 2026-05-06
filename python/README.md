# Python Code Challenges

This directory contains Python implementations of various coding challenges and algorithms.

## Directory Structure

```
python/
├── problems/           # Problem solutions
│   └── string_reversal_problem.py
├── utils/             # Utility functions and helpers
├── tests/             # Test suites
│   └── test_string_reversal_problem.py
├── conftest.py        # Pytest configuration
└── __init__.py        # Package initialization
```

## Setup

### Prerequisites
- Python 3.8+
- pip (Python package manager)

### Installation

1. Install dependencies:
```bash
pip install -r requirements.txt
```

## Running Tests

### Run all tests
```bash
pytest python/tests/ -v
```

### Run specific test file
```bash
pytest python/tests/test_string_reversal_problem.py -v
```

### Run tests with coverage
```bash
pytest python/tests/ --cov=python/problems --cov-report=html
```

## Problems Implemented

### 1. String Reversal Problem
**File:** `python/problems/string_reversal_problem.py`

Reverse a given string without using the standard reverse function. The implementation includes multiple approaches:

- **Two-Pointer Approach** (Most Efficient)
  - Time Complexity: O(n)
  - Space Complexity: O(n) for output, O(1) auxiliary
  - Best for interview questions and real-world scenarios

- **Recursive Approach**
  - Time Complexity: O(n)
  - Space Complexity: O(n) due to call stack
  - Educational purposes

- **Slicing Approach**
  - Time Complexity: O(n)
  - Space Complexity: O(n)
  - Pythonic and concise

- **Built-in Reversed Approach**
  - Time Complexity: O(n)
  - Space Complexity: O(n)
  - Reference implementation

#### Example Usage
```python
from python.problems.string_reversal_problem import StringReversalProblem

problem = StringReversalProblem()

# Using the efficient two-pointer approach
print(problem.reverse_string("hello"))  # Output: olleh
print(problem.reverse_string("Java"))   # Output: avaJ

# Using recursive approach
print(problem.reverse_string_recursive("hello"))  # Output: olleh

# Using slicing approach
print(problem.reverse_string_slicing("hello"))  # Output: olleh

# Using built-in reversed approach
print(problem.reverse_string_using_reversed_builtin("hello"))  # Output: olleh
```

## Testing

Each problem includes comprehensive test cases covering:
- Basic functionality
- Edge cases (null, empty strings, single characters)
- Special characters and unicode
- Long strings
- Performance scenarios

Test results should show:
- All tests passing ✓
- Coverage analysis
- Execution time

## Code Style

The Python code follows:
- [PEP 8](https://www.python.org/dev/peps/pep-0008/) style guidelines
- [Google-style docstrings](https://google.github.io/styleguide/pyguide.html#38-comments-and-docstrings)
- Type hints where applicable

## Contributing

When adding new problems:
1. Create a new file in `python/problems/` following the naming convention: `problem_name.py`
2. Include comprehensive docstrings with complexity analysis
3. Create corresponding test file in `python/tests/` named `test_problem_name.py`
4. Ensure all tests pass and add edge cases
5. Update this README with the new problem

## Notes

- All implementations prioritize clarity and efficiency
- Complexity analysis is included in docstrings
- Multiple approaches are provided where applicable to demonstrate different techniques
- Tests are comprehensive and cover edge cases
