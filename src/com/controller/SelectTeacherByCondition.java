package com.controller;

import com.dao.ExcuseDao;
import com.dao.UserDao;
import com.model.Excuse;
import com.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/select_teacher")
public class SelectTeacherByCondition extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String condition=req.getParameter("condition");

        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        String username = (String) session.getAttribute("username");
        List<User> userlist;
        try {
            userlist= UserDao.getTeacherByCondition(condition);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("teacher_list", userlist);
        req.setAttribute("data_source", "teacher_list");
        req.getRequestDispatcher("/User_TeacherList.jsp").forward(req, resp);
    }

}