package com.controller;

import com.dao.ExcuseDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id=req.getParameter("id");
        String agree=req.getParameter("agree");
        ExcuseDao excuseDao=new ExcuseDao();
        try {
            excuseDao.checkExcuse(agree,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        req.setAttribute("excuse", excuse);
//        req.getRequestDispatcher("/I.jsp").forward(req, resp);
    }
}