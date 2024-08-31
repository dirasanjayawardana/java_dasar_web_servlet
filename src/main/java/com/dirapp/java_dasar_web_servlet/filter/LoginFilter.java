package com.dirapp.java_dasar_web_servlet.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") // Filter akan diterapkan untuk semua url
public class LoginFilter extends HttpFilter {

  // Filter adalah fitur yang digunakan sebagai penjagaan sebelum object Servlet diakses, menetukan request dapat dilanjutkan atau tidak
  // Filter biasa disebut juga sebagai Middleware di bahasa pemrograman lain
  // Filter merupakan interface, class implementasinya bisa menggunakan HttpFilter
  // @WebFilter(url) --> untuk membuat Filter harus menggunakan annotasi di class nya dan extends HttpFilter
  // FilterChain.doFilter(req, res) --> melanjutkan request dan response ke Servlet selanjutnya atau Filter selanjutnya (jika ada)

  @Override
  protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (request.getRequestURI().equals("/session/login")) {
      chain.doFilter(request, response);
    } else {
      HttpSession session = request.getSession(true);
      String username = (String) session.getAttribute("username");

      if (username == null) {
        response.setStatus(401);
        response.getWriter().println("You need to login first");
      } else {
        chain.doFilter(request, response);
      }
    }
  }
}