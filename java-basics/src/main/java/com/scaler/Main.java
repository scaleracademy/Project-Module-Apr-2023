package com.scaler;

import com.scaler.greet.Greeting;
import com.scaler.http.Client;
import com.scaler.rest.RestClient;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("args = " + Arrays.toString(args));

        String arg = "greet";
        if (args.length > 0) {
            arg = args[0];
        }

        switch (arg) {
            case "greet":
                System.out.println("Greeting: " + new Greeting().greeting());
                break;
            case "http":
                Client client = new Client();
                String response = client.get("https://example.com");
                System.out.println(response);
                break;
            case "rest":
                RestClient restClient = new RestClient();
                var apiResponse = restClient.getApi().getPhotos().execute();

                apiResponse.body().forEach(photo -> {
                    System.out.println(photo.getTitle());
                });
        }
    }
}