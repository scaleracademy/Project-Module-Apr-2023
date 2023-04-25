package com.scaler.greet;

public class Greeting {

    /**
     * generate a greeting based on time of the day
     * @return
     */
    public String greeting() {
        int hour = java.time.LocalTime.now().getHour();
        if (hour >= 0 && hour < 12) {
            return "Good morning";
        } else if (hour >= 12 && hour < 16) {
            return "Good afternoon";
        } else {
            return "Good evening";
        }
    }
}
