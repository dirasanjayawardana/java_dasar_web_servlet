package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/body")
public class BodyServlet extends HttpServlet {
    // Semua HTTP Request yang masuk ke Servlet akan disimpan dalam object ServletRequest
    // Saat menggunakan class HttpServlet, object ServletRequest akan dikonversi menjadi HttpServletRequest
    // HttpServletRequest --> representasi dari Http request (data yg diterima)
    // HttpServletResponse --> representasi dari Http response (data yg dikirim)

    // untuk mengirim response ke body bisa menggunakan PrintWriter pada method getWriter()
    // method getWriter() akan menulis apapun ke body pada Http Response

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = """
                <html>
                <body>
                <h1>Dira Sanjaya Wardana</h1>
                </body>
                </html>
                """;
        resp.getWriter().println(html);
    }
}