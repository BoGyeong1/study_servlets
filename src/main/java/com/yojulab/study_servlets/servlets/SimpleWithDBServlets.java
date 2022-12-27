package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.study_servlets.dao.SimpleWithDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple/withDBServlets")
public class SimpleWithDBServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // biz with DB
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        // 값 가져오기
        ArrayList<HashMap> bundle_list = simpleWithDB.getList();

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>SimpleWithDBServlets</div>");

        for (int i = 0; i < bundle_list.size(); i++) {
            HashMap<String, Object> bundle = bundle_list.get(i);
            HashMap<String, Object> question = (HashMap<String, Object>) bundle.get("question");
            int orders = (int) question.get("ORDERS");
            String questions = (String) question.get("QUESTIONS");
            String questions_uid = (String) question.get("QUESTIONS_UID");
            printWriter.println("<div>" + orders + ". " + questions + "<input type='hidden' value = '" + questions_uid
                    + "' / ></div>");
        }

        printWriter.close();

    }

}
