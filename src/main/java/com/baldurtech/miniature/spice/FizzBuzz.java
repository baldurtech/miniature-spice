package com.baldurtech.miniature.spice;

public class FizzBuzz {
    public String say(Integer num) {
        if(num % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(num);
    }

    static Boolean testResult = true;

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals("1", fizzBuzz.say(1));

        assertEquals("2", fizzBuzz.say(2));

        assertEquals("Fizz", fizzBuzz.say(3));

        outputTestReport();
    }

    public static void assertEquals(String expectedResult, String actualResult) {
        if(false == expectedResult.equals(actualResult)) {
            testResult = false;
            System.out.println("Expected `" + expectedResult + "`, but `" + actualResult + "`");
        }
    }

    private static void outputTestReport() {
        if(testResult) {
            System.out.println("TEST SUCCESS!");
        } else {
            System.out.println("FAIL!");
        }
    }
}
