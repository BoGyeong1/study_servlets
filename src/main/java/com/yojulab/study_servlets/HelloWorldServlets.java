package com.yojulab.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlets")
public class HelloWorldServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String hiddenParam = request.getParameter("hiddenParam");

        PrintWriter printWriter = response.getWriter();
        String messege = "Hello World Servlets with Message! ";
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<title> " + messege + "</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div> firstName : " + firstName + "</div>");
        printWriter.println("<div> secondName : " + secondName + "</div>");
        printWriter.println("<form action='/helloWorldServlets' method='get'>");
        printWriter.println("<input type='text' name='firstName' id='' value='" + firstName + "' />");
        printWriter.println("<input type='text' name='secondName' id='' value='" + secondName + "' />");
        printWriter.println("<button>recall HelloWorldServlets</button>");
        printWriter.println("</form>");
        printWriter.println("</body></html>");

        printWriter.close();
    }

}
