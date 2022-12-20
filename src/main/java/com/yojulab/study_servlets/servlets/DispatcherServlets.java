package com.yojulab.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlets")
public class DispatcherServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String hiddenParam = request.getParameter("hiddenParam");
        // /dispatcherServlets?hiddenParam=searchFormServlet
        if ("searchFormServlet".equals(hiddenParam)) {
            // 파라메터를 포함시켜 보낼 수가 없다. 주소창뒤에 써줘야하는 불편함..

            response.sendRedirect("/searchFormServlet");
            // /dispatcherServlets?hiddenParam=CreateCookieServlets
        } else if ("CreateCookieServlets".equals(hiddenParam)) {
            request.setAttribute("firstName", "bogyeong");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cookies/createServlets");
            requestDispatcher.forward(request, response);
        } else {

            // nomal Display
            PrintWriter printWriter = response.getWriter();
            String messege = "Dispatcher Servlets with Message! ";
            printWriter.println("<html lang='en'>");
            printWriter.println("<head>");
            printWriter.println("<title> " + messege + "</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");

            printWriter.println("<form action='/helloWorldServlets' method='get'>");

            printWriter.println("<button>call DispatcherServlets</button>");
            printWriter.println("</form>");
            printWriter.println("</body></html>");

            printWriter.close();
        }

    }

}
