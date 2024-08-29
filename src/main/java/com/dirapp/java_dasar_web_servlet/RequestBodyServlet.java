package com.dirapp.java_dasar_web_servlet;

import java.io.IOException;
import java.util.Map;

import com.dirapp.java_dasar_web_servlet.model.SayHelloRequest;
import com.dirapp.java_dasar_web_servlet.util.JsonUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/api/say-hello")
public class RequestBodyServlet extends HttpServlet {
  // getInputStream() --> untuk mendapatkan Body dalam bentuk Input Stream
  // getBufferReader() --> untuk mendapatkan Body dalam bentuk Buffered Reader

  @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayHelloRequest sayHelloRequest = JsonUtil.getObjectMapper().readValue(req.getReader(), SayHelloRequest.class);
        
        String sayHello = "Hello " + sayHelloRequest.getFirstName() + " " + sayHelloRequest.getLastName();

        Map<String, String> response = Map.of(
                "data", sayHello
        );
        String jsonResponse = JsonUtil.getObjectMapper().writeValueAsString(response);

        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().println(jsonResponse);
    }
}
