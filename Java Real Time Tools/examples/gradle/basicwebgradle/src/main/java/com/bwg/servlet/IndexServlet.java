package com.bwg.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String javaVersion = System.getProperty("java.version");
        req.setAttribute("javaVersion", javaVersion);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
