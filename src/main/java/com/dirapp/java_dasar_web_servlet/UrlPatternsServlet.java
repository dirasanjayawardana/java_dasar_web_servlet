package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/patterns/*") // maka url /patterns/apapun akan masuk ke url ini
public class UrlPatternsServlet extends HttpServlet {
    // bisa menggunakan url pattern, contohnya /contoh/* atau /contoh/*.json

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(req.getRequestURI());
    }
}