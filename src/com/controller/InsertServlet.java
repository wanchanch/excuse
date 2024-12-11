package com.controller;

import com.dao.ExcuseDao;
import com.model.Excuse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sname = req.getParameter("sname");
        String sclass = req.getParameter("sclass");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        String type = req.getParameter("type");
        String why = req.getParameter("why");

        String username = (String) req.getSession().getAttribute("username");

        Excuse excuse = new Excuse();
        excuse.setSname(sname);
        excuse.setSclass(sclass);
        excuse.setStart(start);
        excuse.setEnd(end);
        excuse.setType(type);
        excuse.setWhy(why);
        excuse.setUsername(username);

        ExcuseDao excuseDao = new ExcuseDao();
        try {
            int result = excuseDao.insertExcuse(excuse);
            if (result > 0) {
                resp.getWriter().write("<script>window.location.href='list';</script>");
            } else {
                resp.getWriter().write("插入失败");
            }
        } catch (SQLException e) {
            resp.getWriter().write("插入失败");
            throw new RuntimeException(e);
        }
    }
}
