package com.scaler.blogapi.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.scaler.blogapi.security.TokenService;

public class JWTTokenService implements TokenService {

    private final Algorithm algorithm;
    // TODO: read this key from .properties file instead of hardcoding in source code
    private final String SIGNING_KEY = "a long key that is to sign tokens; do not share it with anyone";
    private final long TOKEN_EXPIRY_MILLIS = 1000 * 60 * 60 * 24; // 24 hrs
    private final String ISSUER = "blog-api";

    public JWTTokenService() {
        this.algorithm = Algorithm.HMAC256(SIGNING_KEY);
    }

    @Override
    public String createAuthToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer(ISSUER)
                .withIssuedAt(new java.util.Date())
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + TOKEN_EXPIRY_MILLIS))
                .sign(algorithm);
    }

    @Override
    public String getUsernameFromToken(String token) throws IllegalStateException {
        var verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();

        var decodedToken = verifier.verify(token);
        return decodedToken.getSubject();
    }
}
