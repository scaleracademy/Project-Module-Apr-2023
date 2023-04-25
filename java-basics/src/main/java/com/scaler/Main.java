package com.scaler;

import com.scaler.greet.Greeting;

public class Main {
    public static void main(String[] args) {
        Greeting greet = new Greeting();
        System.out.println(greet.greeting());
    }
}