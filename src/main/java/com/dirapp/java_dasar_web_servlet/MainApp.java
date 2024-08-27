package com.dirapp.java_dasar_web_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MainApp {
    // java springboot memiliki Embedded Tomcat, dengan running main class dan mengaktifkan @ServletComponentScan
    // untuk proses development agar tidak perlu build dan copy project ke webapps di Tomcat

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }
}