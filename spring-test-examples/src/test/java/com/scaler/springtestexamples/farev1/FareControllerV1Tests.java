package com.scaler.springtestexamples.farev1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FareControllerV1.class)
@AutoConfigureMockMvc
public class FareControllerV1Tests {

    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    public static class FareServiceTestConfig {
        @Bean
        public FareServiceV1 fareServiceV1() {
            return new FareServiceV1();
        }
    }

    @Test
    void minFareCalculatedCorrectly () throws Exception {

        mockMvc.perform(get("/api/v1/fare/?dist=0&time=0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fare").value("25.00"));

    }

    @Test
    void fareForDistanceAboveMinKm() throws Exception {
        mockMvc.perform(get("/api/v1/fare/?dist=3&time=0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fare").value("33.00"));
    }

    @Test
    void fareForTimeAboveMinWait() throws Exception {
        mockMvc.perform(get("/api/v1/fare/?dist=0&time=20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fare").value("35.00"));
    }


    @Test
    void errorWithMissingParams() throws Exception {
        mockMvc.perform(get("/api/v1/fare/"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void errorWithNonIntegerDistAndTime() throws Exception {
        mockMvc.perform(get("/api/v1/fare/?dist=abc&time=def"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void correctErrorWithNegativeDistance() throws Exception {
        mockMvc.perform(get("/api/v1/fare/?dist=-1&time=0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Distance and time must be positive"));
    }

}
