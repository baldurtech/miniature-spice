package com.baldurtech.miniature.spice;

public class FizzBuzz {
    public String say(Integer num) {
        if(num % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(num);
    }
}
