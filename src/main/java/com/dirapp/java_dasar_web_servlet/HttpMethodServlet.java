package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/method")
public class HttpMethodServlet extends HttpServlet {
    // secara default, Servlet akan mengangani semua jenis HTTP Request dengan method apapun (POST, GET, POST, PUT, DELETE)
    // ketika override method service(), maka request yg masuk akan dialihkan ke method yang sesuai dengan method requestnya
    // misal kan request dengan method GET akan dialihkan ke doGet() secara otomatis ketika menggunakan service()
    // jika hanya ingin membuat logic untuk HTTP Method tertentu, tidak perlu override service()
    // cukup override method doNamaMethodnya(), contohnya doGet(), doPost(), dll

    private List<String> todos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(todos);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo = req.getParameter("todo");
        
        if (todo != null) {
            todos.add(todo);
            resp.getWriter().println("Add todo : " + todo);
        } else {
            resp.getWriter().println("Todo parameter must exists");
        }
    }
}