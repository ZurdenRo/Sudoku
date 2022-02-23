package com.example.application;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.io.IOException;


@SpringBootApplication
public class App{

    public static void main(String[] args) throws IOException{

        SpringApplication.run(App.class, args);

    }



}