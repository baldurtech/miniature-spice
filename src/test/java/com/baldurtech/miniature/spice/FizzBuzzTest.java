package com.baldurtech.miniature.spice;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

public class FizzBuzzTest {

    static Boolean testResult = true;

    public static void main(String[] args) throws Exception {
        for(Method method: getAllTestMethods(FizzBuzzTest.class)) {
            System.out.println("testing: " + method.getName());

            // Object obj = new FizzBuzz();
            Object obj = FizzBuzzTest.class.newInstance();

            // obj.methodName();
            method.invoke(obj, new Object[]{});
        }

        outputTestReport();
    }

    private static List<Method> getAllTestMethods(Class clazz) {
        List<Method> testMethods = new ArrayList<Method>();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method: methods) {
            if(method.getName().startsWith("test")) {
                testMethods.add(method);
            }
        }
        return testMethods;
    }

    FizzBuzz fizzBuzz = new FizzBuzz();

    public void test_1_should_be_1() {
        assertEquals("1", fizzBuzz.say(1));
    }

    public void test_2_should_be_2() {
        assertEquals("2", fizzBuzz.say(2));
    }

    public void test_3_should_be_Fizz() {
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
