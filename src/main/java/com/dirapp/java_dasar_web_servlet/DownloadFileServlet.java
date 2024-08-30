package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/download")
public class DownloadFileServlet extends HttpServlet {
    // getWriter() digunakan untuk mengirim response dalam bentuk text
    // getOutputStream() --> untuk mengirim response dalam bentuk binnary

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        Path path = Path.of("upload/" + file);
        
        // hanya menampilkan pada browser
        byte[] bytes = Files.readAllBytes(path);

        String force = req.getParameter("force");
        if ("true".equals(force)) {
            // langsung mendownload file pada browser
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + path.getFileName() + "\"");
        }

        resp.getOutputStream().write(bytes);
    }
}