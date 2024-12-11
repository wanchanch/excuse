package com.controller;

import com.dao.ExcuseDao;
import com.model.Excuse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/select")
public class SelectExcuseByCondition extends HttpServlet {
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
        List<Excuse> selectList= null;

        if ("老师".equals(role)) {
            try {
                selectList = ExcuseDao.getExcuseByCondition(condition);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("excuses", selectList);
            req.getRequestDispatcher("tlist").forward(req, resp);
        }else if ("管理员".equals(role)) {
            try {
                selectList = ExcuseDao.getExcuseByCondition(condition);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("excuses", selectList);
            req.getRequestDispatcher("adminList").forward(req, resp);
        }else if ("学生".equals(role)) {
            try {
                selectList = ExcuseDao.getExcuseByCondition_stu(condition,username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("excuses", selectList);
            req.getRequestDispatcher("list").forward(req, resp);
        }


    }
}