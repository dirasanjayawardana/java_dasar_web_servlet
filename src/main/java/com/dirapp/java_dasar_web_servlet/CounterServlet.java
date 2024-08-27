package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {
  // Saat Java Web dijalankan, Servlet hanya akan dibuat satu kali (singleton)
  // HTTP Reequest yang masuk akan selalu menggunakan Servlet yang sama
  // perlu memastikan kode yang buat harus Thread Safe, agar data antar HTTP Request tidak tertukar

  // contoh praktek yang salah, ketika variabel berada diluar scope service, sehingga bersifat sharing variabel
  // bisa terjadi race condition jika ada request lebih dari satu yang mengakses url yang sama
  // jika memang harus membutuhkan sharing variabel, bisa gunakan AtomicData atau melakukan locking pada variabel

  private final AtomicLong atomicLong = new AtomicLong(0);

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      long total = atomicLong.incrementAndGet();
      String response = "Total Counter : " + total;
      resp.getWriter().println(response);
  }

  
  // Alternatif lain menggunakan synchronized, untuk melakukan locking, agar tidak terjadi race condition

  // private Long counter = 0L;

  // @Override
  // protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //     long total;
  //     synchronized (this) {
  //         total = ++counter;
  //     }
  //     String response = "Total Counter : " + total;
  //     resp.getWriter().println(response);
  // }
}