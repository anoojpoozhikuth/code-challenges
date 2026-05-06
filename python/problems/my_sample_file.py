def reversalFunction(strToReverse):
    """Reverses the input string."""
    charArray = list(strToReverse)
    left, right = 0, len(charArray) - 1
    while left < right:
        charArray[left], charArray[right] = charArray[right], charArray[left]
        left += 1
        right -= 1
    return ''.join(charArray)


if __name__ == "__main__":
    # Test cases
    test_strings = [
        "hello",
        "Python",
        "racecar",
        "hello world",
        "12345",
    ]
    
    print("String Reversal Function Execution")
    print("=" * 50)
    
    for test_str in test_strings:
        reversed_str = reversalFunction(test_str)
        print(f"Original: '{test_str}' -> Reversed: '{reversed_str}'")
    
    print("=" * 50)

