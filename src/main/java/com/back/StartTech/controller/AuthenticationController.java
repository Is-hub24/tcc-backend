package com.back.StartTech.controller;

import com.back.StartTech.entity.Cliente;
import com.back.StartTech.entity.dtos.AuthenticationDTO;
import com.back.StartTech.entity.dtos.RegisterDTO;
import com.back.StartTech.repository.ClienteRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClienteRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
       var usernamepassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
       var auth = this.authenticationManager.authenticate(usernamepassword);

       return ResponseEntity.ok().build();
    }
    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Validated RegisterDTO data){
    if (this.repository.findByEmail(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptdPassword = new BCryptPasswordEncoder().encode((data.password()));
        Cliente novoCliente = new Cliente(data.login(), encryptdPassword, data.role());

        this.repository.save(novoCliente);

        return ResponseEntity.ok().build();


    }
}
