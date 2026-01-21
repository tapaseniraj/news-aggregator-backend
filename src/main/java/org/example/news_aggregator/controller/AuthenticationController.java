package org.example.news_aggregator.controller;

import org.example.news_aggregator.document.User;
import org.example.news_aggregator.dto.request.UserLoginRequest;
import org.example.news_aggregator.dto.request.UserRegisterRequest;
import org.example.news_aggregator.dto.response.UserLoginResponse;
import org.example.news_aggregator.service.AuthenticationService;
import org.example.news_aggregator.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @GetMapping("/test")
    public String test(){
        System.out.println("Hello from test");
        return "OK";
    }

    @PostMapping("/signup")
    public User register(@RequestBody UserRegisterRequest registerUserDto) {
        System.out.println("singup user dto " + registerUserDto + "  ====== ");
        User registeredUser = authenticationService.signup(registerUserDto);
        System.out.println("registered user  " + registeredUser + "  ====== ");
//        return ResponseEntity.ok(registeredUser);
        return registeredUser;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> authenticate(@RequestBody UserLoginRequest loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken((UserDetails) authenticatedUser);

        UserLoginResponse loginResponse = new UserLoginResponse();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
