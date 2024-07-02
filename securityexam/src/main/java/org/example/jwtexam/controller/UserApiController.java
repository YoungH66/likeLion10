package org.example.jwtexam.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.jwtexam.domain.RefreshToken;
import org.example.jwtexam.domain.Role;
import org.example.jwtexam.domain.User;
import org.example.jwtexam.dto.UserLoginDto;
import org.example.jwtexam.dto.UserLoginResponseDto;
import org.example.jwtexam.service.RefreshTokenService;
import org.example.jwtexam.service.UserService;
import org.example.jwtexam.util.JwtTokenizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDto userLoginDto,
                                BindingResult bindingResult, HttpServletResponse response) {
        // username, password 가 null 일때 (정해진 형식과 맞지 않을 경우)
        if(bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        // username과 password 값을 잘 받았다면
        // 서비스에 가입한 사용자 인지 확인
        User user = userService.findByUsername(userLoginDto.getUsername());
        // 요청정보에서 얻어온 비밀번호와 우리 서비스가 갖고 있는 비밀번호가 일치하는지
        if(!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword()))
        {
            return new ResponseEntity("Incorrect Password.. ",HttpStatus.BAD_REQUEST);
        }
        // 일치하는 유저가 있고, 비밀번호도 일치한다.
        // 롤 객체를 꺼내서 롤의 이름만 리스트로 얻어온다.
        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
        // 코튼 발급
        String accessToken = jwtTokenizer.createAccessToken(
                user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);
        String refreshToken = jwtTokenizer.createRefreshToken(
                user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);

        // 리프레시토큰을 db에 저장
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setValue(refreshToken);
        refreshTokenEntity.setUserId(user.getId());

        refreshTokenService.addRefreshToken(refreshTokenEntity);

        // 응답으로 보낼 값을 준비
        UserLoginResponseDto loginResponseDto = UserLoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .name(user.getName())
                .build();

        Cookie accessTokenCookie = new Cookie("accesstoken", accessToken);
        accessTokenCookie.setHttpOnly(true);    // 보안 (쿠키값을 자바스크립트 값은곳에서는 접근할 수 없도록)
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.ACCESS_TOKEN_EXPIRATION_TIME/1000));  // 30m. 쿠키의 유지시간 단위는 초, JWT의 시간 단위는 밀리세컨드

        Cookie refreshTokenCookie = new Cookie("refreshtoken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.REFRESH_TOKEN_EXPIRATION_TIME/1000)); // 7d.

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        return new ResponseEntity(loginResponseDto, HttpStatus.OK);
    }

    @GetMapping("/api/authtest")
    public String authTest(){
        return "authTest";
    }
}
