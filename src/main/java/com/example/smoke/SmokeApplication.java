package com.example.smoke;

import com.example.smoke.models.Game;
import com.example.smoke.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
public class SmokeApplication {

    public static void main(String[] args){
        SpringApplication.run(SmokeApplication.class, args);
    }
    @Bean
    CommandLineRunner run(GameRepository gameRepository){
        return args -> {
            gameRepository.save(new Game(1, "Halo", 100));
            gameRepository.save(new Game(2, "Halo2", 200));
            gameRepository.save(new Game(3, "Halo3", 300));
        };
    }
}
