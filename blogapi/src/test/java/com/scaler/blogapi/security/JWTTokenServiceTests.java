package com.scaler.blogapi.security;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JWTTokenServiceTests {
    private final JWTTokenService jwtTokenService = new JWTTokenService();

    @Test
    public void testCreateAuthToken() {
        String username = "arnavg111";
        String token = jwtTokenService.createAuthToken(username);
        System.out.println(token);
        Assertions.assertNotNull(token);
    }

    @Test
    public void testTokenVerification() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcm5hdmcxMTEiLCJpc3MiOiJibG9nLWFwaSIsImlhdCI6MTY4NDM4MDE4MSwiZXhwIjoxNjg0NDY2NTgxfQ.tnnMWQrx9lF0cU-rBfj_ScDqHrdk1r7CXaXnkh9ViY8";
        String username = jwtTokenService.getUsernameFromToken(token);
        Assertions.assertEquals("arnavg111", username);
    }
}
