package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/query")
public class RequestParamServlet extends HttpServlet {
    // getParameter() bisa digunakan untuk mengambil data dari Query Param ataupun dari Form POST Request
    // getParameter(name) --> mengambil parameter berdasarkan nama tertentu
    // getParameterNames() --> mengambil semua nama parameter yang ada
    // getParameterMap() --> mengambil semua parameter beserta valuenya
    // getParameterValues(name) --> mengambil parameter yang valuenya lebih dari satu
    // contoh http://localhost:8080/query?number=5&number=10

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] numbers = req.getParameterValues("number");
        // int sum = Stream.of(numbers).mapToInt(Integer::parseInt).sum();
        int sum = Stream.of(numbers).mapToInt(num -> Integer.parseInt(num)).sum();

        resp.getWriter().println("Total numbers is " + sum);
    }
}