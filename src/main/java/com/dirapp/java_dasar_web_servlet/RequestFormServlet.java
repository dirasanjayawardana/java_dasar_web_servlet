package com.dirapp.java_dasar_web_servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class RequestFormServlet extends HttpServlet {
    // getParameter() bisa digunakan untuk mengambil data dari Query Param ataupun
    // dari Form POST Request
    // getParameter(name) --> mengambil parameter berdasarkan nama tertentu
    // getParameterNames() --> mengambil semua nama parameter yang ada
    // getParameterMap() --> mengambil semua parameter beserta valuenya
    // getParameterValues(name) --> mengambil parameter yang valuenya lebih dari
    // satu

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Path path = Path.of(RequestFormServlet.class.getResource("/html/form.html").getPath()); // tidak bisa untuk windows
        // String html = Files.readString(path);
        String html2 = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Form</title>
                </head>
                <body>
                <form action="/form" method="post">
                    First Name : <input type="text" name="firstName"> <br>
                    Last Name : <input type="text" name="lastName"> <br>
                    <input type="submit" value="Say Hello">
                </form>
                </body>
                </html>
                                """;
        resp.getWriter().println(html2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String fullName = firstName + " " + lastName;
        String response = "Hello " + fullName;
        resp.getWriter().println(response);
    }
}
