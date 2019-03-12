package com.school.IbnalHaytham;

import com.school.IbnalHaytham.model.AppRole;
import com.school.IbnalHaytham.model.AppUser;
import com.school.IbnalHaytham.service.AccountService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class IbnAlHaythamApplication {

    @Autowired
    private AccountService accountService;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        SpringApplication.run(IbnAlHaythamApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

}
