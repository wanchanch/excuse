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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/tlist")
public class TeacherListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Excuse> excuses=new ArrayList<>();
        HttpSession session = req.getSession();
        String sclass = (String) session.getAttribute("sclass");
        String condition = req.getParameter("condition");
        try {
            if (condition != null && !condition.isEmpty()) {
                excuses = ExcuseDao.getExcuseByCondition(condition);
            } else {
                excuses = ExcuseDao.getExcusesByClass(sclass);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("excuses", excuses);
        req.getRequestDispatcher("/TList.jsp").forward(req, resp);

    }
}
