package com.example.demo.config;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

    @Bean
    CommandLineRunner initProcedure(JdbcTemplate jdbcTemplate) {
        return args -> {

            System.out.println("Criando procedure...");

            jdbcTemplate.execute(
                "DROP PROCEDURE IF EXISTS Sp_ComputarPartida"
            );

            String sql = new String(
                new ClassPathResource("procedure.sql")
                    .getInputStream()
                    .readAllBytes(),
                StandardCharsets.UTF_8
            );

            jdbcTemplate.execute(sql);

            System.out.println(
                "Procedure criada com sucesso!"
            );
        };
    }
}