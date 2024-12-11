package com.controller;

import com.dao.ExcuseDao;
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


@WebServlet("/list")
public class ListExcuse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User user=new User();
        String sname = user.getSname();
        String sclass = user.getSclass();
        Excuse excuse=new Excuse();
        excuse.setSname(sname);
        excuse.setSclass(sclass);
        String condition = req.getParameter("condition");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        List<Excuse> excuses;

        try {
            if (condition != null && !condition.isEmpty()&&username!=null) {
                excuses = ExcuseDao.getExcuseByCondition_stu(condition,username);
            } else {
                excuses = ExcuseDao.getExcusesByUsername(username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("excuses", excuses);
        req.getRequestDispatcher("/List.jsp").forward(req, resp);
    }
}
