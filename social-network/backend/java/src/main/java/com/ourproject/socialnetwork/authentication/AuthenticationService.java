package com.ourproject.socialnetwork.authentication;

import com.ourproject.socialnetwork.config.JwtService;
import com.ourproject.socialnetwork.config.Role;
import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.mapper.UserMapper;
import com.ourproject.socialnetwork.model.AuthenticationDto;
import com.ourproject.socialnetwork.model.RegisterDto;
import com.ourproject.socialnetwork.repository.UserRepository;
import com.ourproject.socialnetwork.service.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final SequenceGeneratorService userSequenceService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterDto request) {
        var user = UserMapper.INSTANCE.registerDtoToUser(request);
        user.setUserId(userSequenceService.generateSequence(User.SEQUENCE_NAME));
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        var user = userRepository.findUserByUsername(request.username()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
