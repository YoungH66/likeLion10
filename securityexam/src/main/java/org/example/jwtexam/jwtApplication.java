package org.example.jwtexam;

import io.jsonwebtoken.Claims;
import org.example.jwtexam.util.JwtTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class jwtApplication {

	private static final Logger log = LoggerFactory.getLogger(jwtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(jwtApplication.class, args);
	}

	@Autowired
	JwtTokenizer jwtTokenizer;
	@Bean
	public CommandLineRunner run(){
		return args -> {
			String accessToken = jwtTokenizer.createAccessToken(
					1L, "test@test.com", "test", "testuser", Arrays.asList("ROLE_USER", "ROLE_ADMIN")
			);
			log.info("AccessToken :: {}", accessToken);

			String refreshToken = jwtTokenizer.createRefreshToken(
					1L, "test@test.com", "test", "testuser", Arrays.asList("ROLE_USER", "ROLE_ADMIN")
			);
			log.info("RefreshToken :: {}", refreshToken);

//			Long id = jwtTokenizer.getUserIdFromToken(accessToken);
//			log.info("User id :: {}", id);

			Claims claims = jwtTokenizer.parseAccessToken(accessToken);
			log.info("Access Token's Claims :: {}", claims);
			log.info("userId :: {}", claims.get("userId"));

//			Claims refreshTokenClaims = jwtTokenizer.parseRefreshToken(refreshToken);
//			log.info("Refresh Token's Claims :: {}", refreshTokenClaims);
		};
	}
}
