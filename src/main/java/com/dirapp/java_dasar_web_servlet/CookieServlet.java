package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
  // Cookie adalah informasi yang dibuat di server dan disimpan di client
  // Cookie selalu dikirim ulang oleh browser setiap melakukan request
  // addCookie(cookie) --> untuk membuat Cookie
  // getCookies() --> untuk membaca cookie yang dikirim oleh browser
  // Cookie.setMaxAge(-1) --> agar cookie menjadi expire, browser akan otomatis menghapus cookie yg expire

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String cookieName = req.getParameter("name");
    String cookieValue = req.getParameter("value");

    Cookie cookie = new Cookie(cookieName, cookieValue);
    cookie.setPath("/");

    resp.addCookie(cookie);
    resp.getWriter().println("Success add cookie " + cookieName + ":" + cookieValue);
  }
  

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getCookies() != null) {
      for (Cookie cookie : req.getCookies()) {
        resp.getWriter().println("Cookie " + cookie.getName() + ":" + cookie.getValue());
      }
    }
  }
}