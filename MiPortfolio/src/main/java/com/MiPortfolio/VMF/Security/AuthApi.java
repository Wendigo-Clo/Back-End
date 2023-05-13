/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Security;

import com.MiPortfolio.VMF.Entity.Usuario;
import com.MiPortfolio.VMF.Security.jwt.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping ("/api")
public class AuthApi {
    @Autowired
    AuthenticationManager  authManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @PostMapping("/login")
    public ResponseEntity <?> login (@RequestBody @Valid AuthRequest request){
        try{
            Authentication authentication=authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            request.getEmail(), request.getPassword()));
            Usuario user =(Usuario) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
            
            return ResponseEntity.ok().body(response);
        }catch (BadCredentialsException ex){
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
}
