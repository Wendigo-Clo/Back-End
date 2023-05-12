/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF;

import com.MiPortfolio.VMF.Entity.Usuario;
import com.MiPortfolio.VMF.Repository.IUsuarioRepo;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests{
    @Autowired
    IUsuarioRepo repo;
    
    @Test
    public void testCreateUser(){
        PasswordEncoder passwordEncoder = new  BCryptPasswordEncoder();
        String rawPassword = "admin123"; //Contraseña de inicio
        String encodePassword=passwordEncoder.encode(rawPassword);
        Usuario newUsuario= new Usuario("violemf@gmail.com", encodePassword); //correo de inicio
        Usuario savedUsuario=repo.save(newUsuario);
        assertThat(savedUsuario).isNotNull();
        assertThat(savedUsuario.getId()).isGreaterThan(0);
    }
}