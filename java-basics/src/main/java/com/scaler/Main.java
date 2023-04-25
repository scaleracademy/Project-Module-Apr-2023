package com.scaler;

import com.scaler.greet.Greeting;
import com.scaler.http.Client;

public class Main {
    public static void main(String[] args) {
        Greeting greet = new Greeting();
        System.out.println(greet.greeting());

        Client client = new Client();

        String response = client.get("https://example.com");
        System.out.println(response);
    }
}