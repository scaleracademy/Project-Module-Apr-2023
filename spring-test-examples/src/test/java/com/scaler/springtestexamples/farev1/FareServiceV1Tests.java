package com.scaler.springtestexamples.farev1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FareServiceV1Tests {

    private final FareServiceV1 fareService = new FareServiceV1();

    @Test
    void minFareCalculatedCorrectly() {
        String fare = fareService.calcFare(0, 0);

        assertEquals("25.00", fare);

    }

    @Test
    void fareForDistanceAboveMinKm() {
        String fare = fareService.calcFare(3, 0);

        assertEquals("33.00", fare);
    }

    @Test
    void fareForTimeAboveMinWait() {
        String fare = fareService.calcFare(0, 20);

        assertEquals("35.00", fare);
    }

    @Test
    void exceptionForNegativeDistance() {
        assertThrows(IllegalArgumentException.class, () -> fareService.calcFare(-1, 0));
    }

    @Test
    void exceptionForNegativeTime() {
        assertThrows(IllegalArgumentException.class, () -> fareService.calcFare(0, -1));
    }
}
