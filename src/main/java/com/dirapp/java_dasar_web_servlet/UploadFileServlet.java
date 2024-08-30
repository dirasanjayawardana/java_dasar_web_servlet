package com.dirapp.java_dasar_web_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/file-upload")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
    // file upload direpresentasikan dalam interface Part
    // @MultipartConfig(settings) --> menunjukkan bahwa servlet tersebut bisa menerima file upload, bisa menambahkan settings di @MultipartConfig
    // getPart(name) --> mendapatkan file updaload berdasarkan nama
    // getParts() --> mendapatkan semua file upload

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Path path =
        // Path.of(UploadFileServlet.class.getResource("/html/form-upload.html").getPath());
        // String html = Files.readString(path);
        String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Form Upload</title>
                </head>
                <body>
                <form action="/file-upload" method="post" enctype="multipart/form-data">
                  Name : <input type="text" name="name"> <br>
                  Profile : <input type="file" name="profile"> <br>
                  <input type="submit" value="Upload Image">
                </form>
                </body>
                </html>
                                """;
        resp.getWriter().println(html);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Part profile = req.getPart("profile");

        Path uploadLocation = Path.of("upload/" + UUID.randomUUID().toString() + profile.getSubmittedFileName());
        Files.copy(profile.getInputStream(), uploadLocation);

        String html = """
                <html>
                <body>
                Name : $name
                <br>
                Profile : <img width="400px" height="400px" src="/download?file=$profile" />
                </body>
                <html>
                """
                .replace("$name", name)
                .replace("$profile", uploadLocation.getFileName().toString());

        resp.getWriter().println(html);
    }
}