package com.dao;

import com.model.Excuse;
import com.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExcuseDao {
    public static List<Excuse> getExcuse() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Excuse> excuses = new ArrayList<Excuse>();
        String sql = "select * from excuse.excuse;";
        boolean flag = false;
        conn= Utils.getConnection();
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()) {
            Excuse excuse = new Excuse();
            excuse.setUsername(rs.getString("username"));
            excuse.setId(rs.getString("id"));
            excuse.setSname(rs.getString("sname"));
            excuse.setSclass(rs.getString("sclass"));
            excuse.setStart(rs.getString("start"));
            excuse.setEnd(rs.getString("end"));
            excuse.setType(rs.getString("type"));
            excuse.setWhy(rs.getString("why"));
            excuse.setAgree(rs.getString("agree"));
            excuses.add(excuse);
        }
        return excuses;
    }
    //获取所以假条（admin）
    public static List<Excuse> getExcusesByUsername(String username) throws SQLException {
        List<Excuse> excuses = new ArrayList<>();
        String sql = "SELECT * FROM excuse WHERE username = ?";
        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Excuse excuse = new Excuse();
                    excuse.setId(rs.getString("id"));
                    excuse.setSname(rs.getString("sname"));
                    excuse.setSclass(rs.getString("sclass"));
                    excuse.setStart(rs.getString("start"));
                    excuse.setEnd(rs.getString("end"));
                    excuse.setType(rs.getString("type"));
                    excuse.setWhy(rs.getString("why"));
                    excuse.setAgree(rs.getString("agree"));
                    excuses.add(excuse);
                }
            }
        }
        return excuses;
    }
    //通过用户获取（学生）
    public static List<Excuse> getExcusesByClass(String sclass) throws SQLException {
        List<Excuse> excuses = new ArrayList<>();
        String sql = "SELECT * FROM excuse WHERE sclass = ?";
        try (Connection conn = Utils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, sclass);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Excuse excuse = new Excuse();
                    excuse.setId(rs.getString("id"));
                    excuse.setSname(rs.getString("sname"));
                    excuse.setSclass(rs.getString("sclass"));
                    excuse.setStart(rs.getString("start"));
                    excuse.setEnd(rs.getString("end"));
                    excuse.setType(rs.getString("type"));
                    excuse.setWhy(rs.getString("why"));
                    excuse.setAgree(rs.getString("agree"));
                    excuse.setUsername(rs.getString("username"));
                    excuses.add(excuse);
                }
            }
        }
        return excuses;
    }
    //通过班级获取（老师）
    public int insertExcuse(Excuse excuse) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO excuse (sname, sclass, start, end, type, why, username) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int count = 0;
        try {
            conn = Utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, excuse.getSname());
            ps.setString(2, excuse.getSclass());
            ps.setString(3, excuse.getStart());
            ps.setString(4, excuse.getEnd());
            ps.setString(5, excuse.getType());
            ps.setString(6, excuse.getWhy());
            ps.setString(7, excuse.getUsername());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    //增加假条（学生）
    public int modifyExcuse(Excuse excuse) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="update excuse.excuse set sname=?,sclass=?,start=?,end=?,type=?,why=?,agree=? where id=?";
        int count=0;
        try {
            conn= Utils.getConnection();
            ps=conn.prepareStatement(sql);

            ps.setString(1, excuse.getSname());
            ps.setString(2, excuse.getSclass());
            ps.setString(3, excuse.getStart());
            ps.setString(4, excuse.getEnd());
            ps.setString(5, excuse.getType());
            ps.setString(6, excuse.getWhy());
            ps.setString(7, excuse.getAgree());
            ps.setString(8, excuse.getId());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    //修改假条（学生）
    public int deleteExcuse(Excuse excuse) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="delete from excuse.excuse where id=?";
        int count=0;
        try {
            conn= Utils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, excuse.getId());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    //    删除假条
    public int checkExcuse(String agree, String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="update excuse.excuse set agree=? where id=?";
        int count=0;
        try {
            conn= Utils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,agree);
            ps.setString(2,id);
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    //    修改假条（老师，ａｄｍｉｎ）
    public static List<Excuse> getExcuseByCondition(String condition) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Excuse> excuses = new ArrayList<Excuse>();
        try {
            conn = Utils.getConnection();
            String sql = "SELECT * FROM excuse.excuse WHERE CONCAT_WS(',',id, sname,sclass,start,end,type,why,username) LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + condition + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                Excuse excuse = new Excuse();
                excuse.setId(rs.getString("id"));
                excuse.setSname(rs.getString("sname"));
                excuse.setSclass(rs.getString("sclass"));
                excuse.setStart(rs.getString("start"));
                excuse.setEnd(rs.getString("end"));
                excuse.setType(rs.getString("type"));
                excuse.setWhy(rs.getString("why"));
                excuse.setAgree(rs.getString("agree"));
                excuse.setUsername(rs.getString("username"));
                excuses.add(excuse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return excuses;
    }
    //    通过条件查询假条
    public static List<Excuse> getExcuseByCondition_stu(String condition,String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Excuse> excuses = new ArrayList<Excuse>();
        try {
            conn = Utils.getConnection();
            String sql = "SELECT * FROM excuse.excuse WHERE CONCAT_WS(',',id, sname,sclass,start,end,type,why,username) LIKE ? and username=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + condition + "%");
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()){
                Excuse excuse = new Excuse();
                excuse.setId(rs.getString("id"));
                excuse.setSname(rs.getString("sname"));
                excuse.setSclass(rs.getString("sclass"));
                excuse.setStart(rs.getString("start"));
                excuse.setEnd(rs.getString("end"));
                excuse.setType(rs.getString("type"));
                excuse.setWhy(rs.getString("why"));
                excuse.setAgree(rs.getString("agree"));
                excuse.setUsername(rs.getString("username"));
                excuses.add(excuse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return excuses;
    }
    //通过用户名获取假条（学生）
}
