package com.baldurtech.miniature.spice;

public class FizzBuzzTest {

    static Boolean testResult = true;

    public static void main(String[] args) {
        test_1_should_be_1();

        test_2_should_be_2();

        test_3_should_be_Fizz();

        outputTestReport();
    }

    public static void test_1_should_be_1() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1", fizzBuzz.say(1));
    }

    public static void test_2_should_be_2() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("2", fizzBuzz.say(2));
    }

    public static void test_3_should_be_Fizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.say(3));
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
