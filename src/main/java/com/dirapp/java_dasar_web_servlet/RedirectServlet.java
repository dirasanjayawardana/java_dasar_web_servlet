package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet {
  // untuk melakukan redirect, cukup memberi response dengan status code 3xx dan header Location ke lokasi yg baru
  // di Sevlet bisa menggunakan method sendRedirect(url)

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("/form");

    // jika tanpa menggunakan sendRedirect
    // resp.setStatus(HttpServletResponse.SC_FOUND);
    // resp.setHeader("Location", "/form");
  }
}