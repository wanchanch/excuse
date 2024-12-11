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

@WebServlet("/update")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String sname = req.getParameter("sname");
        String sclass = req.getParameter("sclass");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        String type = req.getParameter("type");
        String why = req.getParameter("why");
        String agree = req.getParameter("agree");

        Excuse excuse = new Excuse();
        excuse.setId(id);
        excuse.setSname(sname);
        excuse.setSclass(sclass);
        excuse.setStart(start);
        excuse.setEnd(end);
        excuse.setType(type);
        excuse.setWhy(why);
        excuse.setAgree(agree);
        if (excuse != null) {
            ExcuseDao excuseDao = new ExcuseDao();
            try {
                excuseDao.modifyExcuse(excuse);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("excuse", excuse);
            req.getRequestDispatcher("list").forward(req, resp);
        }
    }
}