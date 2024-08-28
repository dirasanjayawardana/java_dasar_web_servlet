package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/header")
public class RequestHeaderServlet extends HttpServlet {
  // getHeader(name) --> mendapatkan value header berdasarkan nama
  // getHeaderValues(name) --> mendapatkan value header yg lebih dari satu berdasarkan nama
  // getHeaderNames() --> mendapatkan semua nama header
  // getDateHeader(name) --> mendapatkan value header yang bernilai date (millis)
  // getIntHeader(name) --> mendapatkan value header yang int
  // Perlu diingat bahwa name header itu tidak case sensitive, jadi Content-Type dengan content-type adalah nama yg sama

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Enumeration<String> names = req.getHeaderNames();

    String name;
    while ((name = names.nextElement()) != null) {
      String value = req.getHeader(name);
      resp.getWriter().println("Header - " + name + " : " + value);
    }
  }
}