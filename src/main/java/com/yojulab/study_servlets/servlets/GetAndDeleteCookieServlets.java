package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/getAndDeleteServlets")
public class GetAndDeleteCookieServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div> GetAndDeleteCookieServlets </div>");

        // get cookie 받을땐 리스트로 받아야한다.
        Cookie cookies[] = request.getCookies();

        // int로 받으려면 캐스트해줘야함
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            printWriter.println("<div> Cookie Name : " + name + " value : " + value + "</div>");

            // delete cookie
            if (name.equals("secondName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

        }

        printWriter.close();
    }

}
