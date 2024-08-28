package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/json")
public class ResponseHeaderJsonServlet extends HttpServlet {

  // untuk mengirim response Header pada HttpResponse bisa menggunakan:
  // setHeader(name, value) --> mengubah header
  // setIntHeader(name, int) --> mengubah header dengan nilai int
  // setDateHeader(name, long) --> mengubah header dengan nilai date (millis)

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String json = """
        {
            "name" : "Dira",
            "value" : 100
        }
        """;
    resp.setHeader("Content-Type", "application/json"); // memberi tahu bahwa response yg dikirim adalah JSON, bukan plain text
    resp.getWriter().println(json);
  }
}