package com.DanielLazureanu.SpringService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringServiceApplication {

    public static void main(String[] args) {

        CsvService csvService = new CsvService();
        System.out.println(csvService);
        // Rularea aplicației Spring Boot
        SpringApplication.run(SpringServiceApplication.class, args);
    }

}