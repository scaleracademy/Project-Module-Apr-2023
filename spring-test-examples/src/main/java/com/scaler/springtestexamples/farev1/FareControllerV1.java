package com.scaler.springtestexamples.farev1;

import com.scaler.springtestexamples.models.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fare")
public class FareControllerV1 {
    private final FareServiceV1 fareService;

    public FareControllerV1(@Autowired FareServiceV1 fareService) {
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }
}
