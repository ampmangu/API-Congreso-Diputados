package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.config.security.JwtUtils;
import com.mangu.congreso_api.config.security.UserDetailsImpl;
import com.mangu.congreso_api.domain.security.JwtResponse;
import com.mangu.congreso_api.domain.security.LoginRequest;
import com.mangu.congreso_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateuser
      (@RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate
            (new UsernamePasswordAuthenticationToken
                (loginRequest.getUsername(),
                    loginRequest.getPassword()));

    SecurityContextHolder.getContext()
        .setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl)
        authentication.getPrincipal();

    return ResponseEntity
        .ok(new JwtResponse(jwt, userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail()));
  }
}
