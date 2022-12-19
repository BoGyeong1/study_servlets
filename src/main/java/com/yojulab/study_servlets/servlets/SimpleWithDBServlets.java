package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.yojulab.study_servlets.dao.SimpleWithDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simpleWithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // biz with DB
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        simpleWithDB.getList();

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>SimpleWithDBServlets</div>");

        printWriter.close();

    }

}
