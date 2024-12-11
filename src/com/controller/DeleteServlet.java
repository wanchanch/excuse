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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        Excuse excuse = new Excuse();
        excuse.setId(id);

        ExcuseDao excuseDao = new ExcuseDao();
        try {
            excuseDao.deleteExcuse(excuse);
            resp.getWriter().write("删除成功");
        } catch (SQLException e) {
            resp.getWriter().write("删除失败 " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
