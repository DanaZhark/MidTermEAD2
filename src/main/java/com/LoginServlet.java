package com;

import com.User;
import com.dao.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();

        user.setUserName(userName);
        user.setPassword(password);

        Dao loginDao = new Dao();

        try {
            String userValidate = loginDao.authenticateUser(user);

            if (userValidate.equals("Admin_Role")) {
                System.out.println("Admin's Home");

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", userName); //setting session attribute
                request.setAttribute("userName", userName);

                Dao.liveUsers.add(user);

                request.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
            } else if (userValidate.equals("Editor_Role")) {
                System.out.println("Editor's Home");

                HttpSession session = request.getSession();
                session.setAttribute("Editor", userName);
                request.setAttribute("userName", userName);

                Dao.liveUsers.add(user);


                request.getRequestDispatcher("/jsp/editor.jsp").forward(request, response);
            } else if (userValidate.equals("User_Role")) {
                System.out.println("User's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10 * 60);
                session.setAttribute("User", userName);
                request.setAttribute("userName", userName);

                Dao.liveUsers.add(user);

                request.getRequestDispatcher("/jsp/user.jsp").forward(request, response);
            } else {
                System.out.println("Error message = " + userValidate);
                request.setAttribute("errMessage", userValidate);

                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    } //End of doPost()
}
