package com.baldurtech.miniature.spice;

public class FizzBuzz {
    public String say(Integer num) {
        return String.valueOf(num);
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println("1".equals(fizzBuzz.say(1)));
        System.out.println("2".equals(fizzBuzz.say(2)));
    }
}
