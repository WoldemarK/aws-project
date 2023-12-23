package com.example.awsproject.rest;

import com.example.awsproject.dto.IUserDto;
import com.example.awsproject.mapper.UserMapper;
import com.example.awsproject.model.IUser;
import com.example.awsproject.secyrity.CustomPrincipal;
import com.example.awsproject.secyrity.SecurityService;
import com.example.awsproject.secyrity.dto.AuthRequestDto;
import com.example.awsproject.secyrity.dto.AuthResponseDto;
import com.example.awsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthRestControllerV1 {

    private final SecurityService securityService;
    private final UserService userService;
    private final UserMapper userMapper;


    @PostMapping("/register")
    public Mono<IUserDto> register(@RequestBody IUserDto dto) {
        IUser entity = userMapper.map(dto);
        return userService.registerUser(entity)
                .map(userMapper::map);
    }

    @PostMapping("/login")
    public Mono<AuthResponseDto> login(@RequestBody AuthRequestDto dto) {
        return securityService.authenticate(dto.getUsername(), dto.getPassword())
                .flatMap(tokenDetails -> Mono.just(
                        AuthResponseDto.builder()
                                .userId(tokenDetails.getUserId())
                                .token(tokenDetails.getToken())
                                .issuedAt(tokenDetails.getIssuedAt())
                                .expiresAt(tokenDetails.getExpiresAt())
                                .build()
                ));
    }

}
