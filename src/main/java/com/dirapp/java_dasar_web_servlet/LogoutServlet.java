package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/session/logout")
public class LogoutServlet extends HttpServlet {
  // Session adalah informasi yang disimpan di Server untuk digunakan kembali oleh Client
  // ketika membuat Session disarankan menggunakan Cookie atau disimpan di Database, bukan disimpan di Memory aplikasi
  // req.getSession(isAutoCreate) --> membuat session, jika isAutoCreate true, ketika session yang dicari tidak ada, maka akan otomatis dibuatkan
  // HttpSession.getAttribute(name) --> mengambil data session berdasarkan nama
  // HttpSession.removeAttribute(name) --> menghapus data session berdasarkan nama
  // HttpSession.invalidate() --> menghapus semua data session


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession(true);
    session.invalidate();

    resp.getWriter().println("Success logout");
  }
}