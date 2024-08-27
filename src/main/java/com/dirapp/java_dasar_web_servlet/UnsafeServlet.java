package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/unsafe")
public class UnsafeServlet extends HttpServlet {
  // Saat Java Web dijalankan, Servlet hanya akan dibuat satu kali (singleton)
  // HTTP Reequest yang masuk akan selalu menggunakan Servlet yang sama
  // perlu memastikan kode yang buat harus Thread Safe, agar data antar HTTP Request tidak tertukar

  // contoh praktek yang salah, karena variabel berada diluar scope service, sehingga bersifat sharing variabel
  // bisa terjadi race condition jika ada request lebih dari satu yang mengakses url yang sama
  // jika memang harus membutuhkan sharing variabel, bisa gunakan AtomicData atau melakukan locking pada variabel

  // private String response = "";

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    Long sleep = Long.parseLong(req.getParameter("sleep"));

    String response = "Hello " + name;

    try {
      Thread.sleep(sleep);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    resp.getWriter().println(response);
  }

  
  // Alternatif lain menggunakan synchronized, untuk melakukan locking, agar tidak terjadi race condition

  // private String response = "";

  // @Override
  // protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // String name = req.getParameter("name");
      // Long sleep = Long.parseLong(req.getParameter("sleep"));

      // synchronized (this) {
          // response = "Hello " + name;

          // try {
              // Thread.sleep(sleep);
          // } catch (InterruptedException e) {
              // throw new RuntimeException(e);
          // }

          // resp.getWriter().println(response);
      // }
  // }
}