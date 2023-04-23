package com.smolnikov.planesale.Auth;

import com.smolnikov.planesale.Entity.User;
import com.smolnikov.planesale.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;



    public AuthentificationResponse register(RegisterRequest registerRequest) {
        if(userRepo.existsByUsername(registerRequest.getUsername())) {
            return null;
        }
        var user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        userRepo.save(user);
        var jwt = jwtService.generateToken(user);
        return AuthentificationResponse.builder()
                .token(jwt)
                .build();

    }

    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepo.findByUsername(request.getUsername())
                .orElseThrow();
        var jwt = jwtService.generateToken(user);
        return AuthentificationResponse.builder()
                .token(jwt)
                .build();
    }
}
