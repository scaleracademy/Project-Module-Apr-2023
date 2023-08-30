package com.scaler.springtestexamples.farev1;

import org.springframework.stereotype.Service;

@Service
public class FareServiceV1 {

    public static final int FARE_PER_KM = 8;
    public static final int FARE_PER_MIN = 2;
    public static final int MIN_FARE = 25;
    public static final int MIN_KM = 2;
    public static final int MIN_WAIT = 15;


    String calcFare(int distance, int time) {
        if (distance < 0 || time < 0) {
            throw new IllegalArgumentException("Distance and time must be positive");
        }

        double fare = MIN_FARE;

        if (distance > MIN_KM) {
            fare += (distance - MIN_KM) * FARE_PER_KM;
        }

        if (time > MIN_WAIT) {
            fare += (time - MIN_WAIT) * FARE_PER_MIN;
        }

        // Format to 2 decimal places
        return String.format("%.2f", fare);
    }

}
