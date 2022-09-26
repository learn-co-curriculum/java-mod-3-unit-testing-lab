# Unit Testing Lab

## Learning Goals

- Write tests to check program logic.

## Introduction

Let's consider a simplified version of the classic "FizzBuzz" logic problem:

- Given an integer as a parameter.
  - If the integer is divisible by 3, return "Fizz".
  - If the integer is divisible by 5, return "Buzz".
  - If the integer is divisible by 3 and 5, return "FizzBuzz".
  - Else, return and print the integer.

Let's consider some code that looks like it should solve this problem:

```java
public class FizzBuzz {
    public String fizzBuzzString(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else if ((number % 3 == 0) && (number % 5 == 0)) {
            return "FizzBuzz";
        }
        else {
            // Will return a String object with the number as its value
            return Integer.toString(number);
        }
    }
}
```

## Instructions

This code has 1 bug! Write some unit tests to test the logic and find the bug
given the following steps:

1. Test the "_not_ divisible by 3 or 5" case first - this should pass.
2. Test the "divisible by 3 only" case - this should also pass.
3. Test the "divisible by 5 only" case - this should also pass.
4. Test the "divisible by 3 and 5" case - _this will not pass_.
5. Fix the logic in the solution so that all 4 test cases pass.
