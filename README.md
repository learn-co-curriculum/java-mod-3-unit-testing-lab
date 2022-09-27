# Unit Testing Code Along

## Learning Goals

- Write tests to check program logic.

## Introduction

Let's consider a simplified version of the classic "FizzBuzz" logic problem:

- Given an integer as a parameter:
  - If the integer is divisible by 3, return "Fizz".
  - If the integer is divisible by 5, return "Buzz".
  - If the integer is divisible by 3 and 5, return "FizzBuzz".
  - Else, return and print the integer.

Let's consider some code that looks like it should solve this problem:

```java
public class FizzBuzz {
    public String fizzBuzzString(int number) {
        if (number % 3 == 0) {
            // if divisible by 3
            return "Fizz";
        } else if (number % 5 == 0) {
            // if divisible by 5
            return "Buzz";
        } else if ((number % 3 == 0) && (number % 5 == 0)) {
            // if divisible by both 3 and 5
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

Fork and clone this repository, so you can see the sample code above in your
IDE.

This code has 1 bug! Write some unit tests to test the logic and find the bug
given the following steps:

1. Test the "_not_ divisible by 3 or 5" case first - this should pass.
2. Test the "divisible by 3 only" case - this should also pass.
3. Test the "divisible by 5 only" case - this should also pass.
4. Test the "divisible by 3 and 5" case - _this will not pass_.
5. Fix the logic in the solution so that all 4 test cases pass.

## Create the Unit Tests

As we saw in the Unit Testing lesson, go ahead and right-click anywhere in the
`fizzBuzzString` method to generate a unit test class.

This should create a `FizzBuzzTest.java` file under the `test` folder that looks
like this:

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fizzBuzzString() {
    }
}
```

Let's go ahead and create the first test: test the "_not_ divisible by 3 or 5"
case - this should pass.

First, think about a number that is not divisible by 3 or 5.

How about the number 7? Let's use that in creating the first unit test!

```java
@Test
void fizzBuzzString() {
    FizzBuzz fizzBuzz = new FizzBuzz();
    assertEquals("7", fizzBuzz.fizzBuzzString(7));
}
```

Use the `assertEquals()` method that we have seen to test if the expected
`String` value is equal to the actual `String`. Don't forget the double-quotes
around 7 to turn it into a `String`.

Now go ahead and run it and make sure it passes with the code unchanged!

Great! Let's add the next unit test: test the "divisible by 3 only" case - this
should also pass.

According to the requirements above, if the integer is divisible by 3, the code
should return the word "Fizz". Create a new unit test since it is best practice
for there to be only one assert per unit test. Use the `assertEquals()` method
again for this too!

```java
@Test
void testFizz() {
    FizzBuzz fizzBuzz = new FizzBuzz();
    assertEquals("Fizz", fizzBuzz.fizzBuzzString(3));
}
```

Let's run this test and double check that it passes as expected!

Hmm... it would seem that the two unit tests both have a line in common:

`FizzBuzz fizzBuzz = new FizzBuzz();`

This will probably be evident in all of our unit tests. So go ahead and move
this to the `setUp()` method like this:

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testElse() {
        assertEquals("7", fizzBuzz.fizzBuzzString(7));
    }

    @Test
    void testFizz() {
        assertEquals("Fizz", fizzBuzz.fizzBuzzString(3));
    }
}
```

Also, go ahead and rename the unit test `fizzBuzzString()` to something more
descriptive. You could maybe rename it to `testElse()` since you are testing
the `else` portion of the `fizzBuzzString()` method. Remember that the test
names should be understood and make sense to other programmers too!

Let's add the third test: test the "divisible by 5 only" case - this should also
pass.

```java
@Test
void testBuzz() {
    assertEquals("Buzz", fizzBuzz.fizzBuzzString(5));
}
```

Try running this test and make sure it passes as expected.

There is one more case we need to test: test the "divisible by 3 and 5" case -
_this will not pass_. Think about a number that is divisible by 3 and 5.

Well, 3 multiplied by 5 is 15 - so we'll use that!

```java
@Test
void testFizzBuzz() {
    assertEquals("FizzBuzz", fizzBuzz.fizzBuzzString(15));
}
```

When you run this, you will see that the test fails for the following reason:

![unit-testing-lab-bug](https://curriculum-content.s3.amazonaws.com/java-mod-3/unit-testing-lab/unit-test-bug.png)

Let's go back to the original code and do some refactoring now to get all four
unit tests passing.

```java
public class FizzBuzz {
    public String fizzBuzzString(int number) {
        if (number % 3 == 0) {
            // if divisible by 3
            return "Fizz";
        } else if (number % 5 == 0) {
            // if divisible by 5
            return "Buzz";
        } else if ((number % 3 == 0) && (number % 5 == 0)) {
            // if divisible by both 3 and 5
            return "FizzBuzz";
        }
        else {
            // Will return a String object with the number as its value
            return Integer.toString(number);
        }
    }
}
```

To figure out what is wrong, you can use the debugger we learned about
previously to help you!

In the `testFizzBuzz()` method, set a breakpoint next to the `assertEquals()`
method and then right-click the green play button. This will bring up an
option menu. Choose the debug option to start the debugger process.

![debug-testFizzBuzz](https://curriculum-content.s3.amazonaws.com/java-mod-3/unit-testing-lab/debug-fizzbuzz-1.png)

When the debugger hits the breakpoint you set, choose the "Step Into" button
(![step-into](https://curriculum-content.s3.amazonaws.com/java-mod-3/debugger/step-in.png)).
This will then highlight the two methods you can step into. When it does, click
the "fizzBuzzString" option.

![highlight-step-into-options](https://curriculum-content.s3.amazonaws.com/java-mod-3/unit-testing-lab/debug-fizzbuzz-2.png)

When you choose the "fizzBuzzString" option, the debugger will jump into the
first line of the `fizzBuzzString()` method:

![jump-to-fizzBuzzString-method](https://curriculum-content.s3.amazonaws.com/java-mod-3/unit-testing-lab/debug-fizzbuzz-3.png)

Let's follow what happens from here. Click the "Step Over" button
(![step-over](https://curriculum-content.s3.amazonaws.com/java-mod-3/debugger/step-over.png))
to see what happens next:

![return-fizz](https://curriculum-content.s3.amazonaws.com/java-mod-3/unit-testing-lab/debug-fizzbuzz-4.png)

When you run the debugger, you will notice that when it enters the
`fizzBuzzString()` method, it checks first to see if the `number` is divisible
by 3. Since 15 _is_ divisible by 3, it will fall into the first `if` statement
and return "Fizz". The case where it is divisible by both 3 and 5 is never
touched!

Let's try moving the `if ((number % 3 == 0) && (number % 5 == 0))` conditional
up, so it is the first conditional:

```java
public class FizzBuzz {
    public String fizzBuzzString(int number) {
        if ((number % 3 == 0) && (number % 5 == 0)) {
            // if divisble by both 3 and 5
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            // if divisible by 3
            return "Fizz";
        } else if (number % 5 == 0) {
            // if divisible by 5
            return "Buzz";
        } else {
            // Will return a String object with the number as its value
            return Integer.toString(number);
        }
    }
}
```

Try re-running the unit test now. The refactoring we did should now have the
test passing!

Let's make sure all of our other tests are working still too. Run all the tests
in the `FizzBuzzTest` class. You should see all 4 tests passing now!
