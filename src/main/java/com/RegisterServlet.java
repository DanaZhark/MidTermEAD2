package com;

import com.User;
import com.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class guru_register
 */
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Dao.users.add(new User(username, password));

        if(username.isEmpty() ||
                password.isEmpty())
        {
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

}
