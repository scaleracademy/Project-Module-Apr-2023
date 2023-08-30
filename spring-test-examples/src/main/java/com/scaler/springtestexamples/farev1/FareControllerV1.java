package com.scaler.springtestexamples.farev1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fare")
public class FareControllerV1 {
    private final FareServiceV1 fareService;

    public FareControllerV1(FareServiceV1 fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/")
    public ResponseEntity<FareResponse> getFare(
            @RequestParam("dist") Integer distance,
            @RequestParam("time") Integer time
    ) {
        String fare = fareService.calcFare(distance, time);

        return ResponseEntity.ok(new FareResponse(fare));
    }
}
