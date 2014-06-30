package com.baldurtech.miniature.spice;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.reflections.Reflections;

public class MiniatureSpiceTestCase {

    static Boolean testResult = true;

    public static void main(String[] args) throws Exception {
        String testPackage = "com.baldurtech.miniature.spice";

        Reflections reflections = new Reflections(testPackage);

        Set<Class<? extends MiniatureSpiceTestCase>> allTestCases =
            reflections.getSubTypesOf(MiniatureSpiceTestCase.class);

        for(Class clazz: allTestCases) {
            System.out.println("Testing: " + clazz.getName());
            runAllTests(clazz);
        }

        outputTestReport();
    }

    private static void runAllTests(Class clazz) throws Exception {
        for(Method method: getAllTestMethods(clazz)) {
            System.out.println("    testing: " + method.getName());

            try {
                // Object obj = new FizzBuzz();
                Object obj = clazz.newInstance();

                // obj.methodName();
                method.invoke(obj, new Object[]{});
            } catch(Exception e) {
                testResult = false;
                System.out.println("Unexpected exception!");
                e.printStackTrace();
            }
        }
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
