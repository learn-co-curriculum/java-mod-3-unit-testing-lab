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