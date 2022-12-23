package com.yojulab.study_servlets.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createJSPServlets?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession httpSession = null;
        // HttpSession httpSession_false = null;
        // // Exists JSESSTIONID
        // httpSession_false = request.getSession(false); //존재하면 인스턴스화
        // httpSession = request.getSession();//무조건 인스턴스화

        // NOT Exists JSESSTIONID
        // httpSession_false = request.getSession(false); // null
        // // JSESSTIONID가 없어도 동작한다. 위에껄 체크를 해야함
        // httpSession = request.getSession(); // 무조건 인스턴스화

        String path = null;
        if ("yojulab".equals(username) && "1234".equals(password)) {
            // login
            // 로그인을 했었는지 안했었는지 파악해야됨 있으면 생성 X 없으면 생성 O
            httpSession = request.getSession(false);
            if (httpSession == null) {
                httpSession = request.getSession();
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
            }

            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            path = "/session/checkLogin.jsp";
        } else {
            // logout
            // 인스턴스를 새로 만든다.
            httpSession = request.getSession(false);
            if (httpSession != null) {
                httpSession.invalidate();
            }
            // null인지 아닌지 꼭 체크하기 JSP 출력시
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            path = "/session/checkLogout.jsp";

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

}
