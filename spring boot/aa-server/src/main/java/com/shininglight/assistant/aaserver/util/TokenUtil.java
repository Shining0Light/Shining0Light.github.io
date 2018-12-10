package com.shininglight.assistant.aaserver.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.shininglight.assistant.aaserver.exception.TokenException;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author: Shane Liu
 * @date: Created in 16:03 12/05/18
 */
@Slf4j
public class TokenUtil {

    public static String createToken(int userId, String pwd) {
        String token = "";
        token= JWT.create().withAudience(userId + "")
                  .sign(Algorithm.HMAC256(pwd));

        return token;
    }

    public static int getUserIdFromToken(String token) throws TokenException {
        String userId = "";
        int userIdNum = 0;
        if (token == null) {
            throw new TokenException("no token");
        }
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException je) {
            throw new TokenException("no id in token");
        }
        try {
            userIdNum = Integer.parseInt(userId);
        } catch (Exception e) {
            throw new TokenException("id must be number");
        }
        return userIdNum;
    }

    public static void validateToken(String pwd, String token) throws TokenException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(pwd)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new TokenException("token invalidate failed");
        }
    }
}
