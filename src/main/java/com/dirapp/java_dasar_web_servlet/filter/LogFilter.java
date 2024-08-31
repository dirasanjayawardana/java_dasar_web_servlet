package com.dirapp.java_dasar_web_servlet.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*") // Filter akan diterapkan untuk semua url
public class LogFilter extends HttpFilter {

  // Filter adalah fitur yang digunakan sebagai penjagaan sebelum object Servlet diakses, menetukan request dapat dilanjutkan atau tidak
  // Filter biasa disebut juga sebagai Middleware di bahasa pemrograman lain
  // Filter merupakan interface, class implementasinya bisa menggunakan HttpFilter
  // @WebFilter(url) --> untuk membuat Filter harus menggunakan annotasi di class nya dan extends HttpFilter
  // FilterChain.doFilter(req, res) --> melanjutkan request dan response ke Servlet selanjutnya atau Filter selanjutnya (jika ada)

  private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

  @Override
  protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    LOGGER.info("Receive request for URL : " + request.getRequestURI());
    chain.doFilter(request, response); // melanjutkan request dan response ke Servlet selanjutnya atau Filter selanjutnya (jika ada)
  }
}