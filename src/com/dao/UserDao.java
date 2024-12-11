package com.dao;

import com.model.User;
import com.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    public int register(User user) throws SQLException {
        int count=0;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "insert into excuse.stu_user(username,password,sname,sclass,sex) values(?,?,?,?,?)";
            conn=Utils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSname());
            ps.setString(4, user.getSclass());
            ps.setString(5, user.getSex());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public static boolean login(String username, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM excuse.stu_user WHERE username = ? AND password = ?";
        boolean flag = false;
        try {
            conn= Utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
    public int teacherRegister(User user) throws SQLException {
        int count=0;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "insert into excuse.teach_user(username,password,sname,sclass,sex) values(?,?,?,?,?)";
            conn=Utils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSname());
            ps.setString(4, user.getSclass());
            ps.setString(5, user.getSex());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public boolean teacherLogin(String username, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM excuse.teach_user WHERE username = ? AND password = ?";
        boolean flag = false;
        try {
            conn= Utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
    public boolean adminLogin(String username, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM excuse.admin WHERE username = ? AND password = ?";
        boolean flag = false;
        try {
            conn= Utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
    //登录、注册

    public static List<User> getUser_student() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userlist = new ArrayList<User>();
        String sql = "select * from excuse.stu_user;";
        boolean flag = false;
        conn= Utils.getConnection();
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()) {
            User user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSname(rs.getString("sname"));
            user.setSclass(rs.getString("sclass"));
            user.setSex(rs.getString("sex"));
            user.setIdentity(rs.getString("identity"));
            userlist.add(user);
        }
        return userlist;
    }
    public static List<User> getUser_teacher() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userlist = new ArrayList<User>();
        String sql = "select * from excuse.teach_user;";
        boolean flag = false;
        conn= Utils.getConnection();
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()) {
            User user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSname(rs.getString("sname"));
            user.setSclass(rs.getString("sclass"));
            user.setSex(rs.getString("sex"));
            user.setIdentity(rs.getString("identity"));
            userlist.add(user);
        }
        return userlist;
    }
    //获取学生，老师数据

    public static User getStudentByUsername(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM excuse.stu_user WHERE username = ?";

        try {
            conn = Utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSname(rs.getString("sname"));
                user.setSclass(rs.getString("sclass"));
                user.setSex(rs.getString("sex"));
                user.setIdentity(rs.getString("identity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
    public static User getTeacherByUsername(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM excuse.teach_user WHERE username = ?";

        try {
            conn = Utils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSname(rs.getString("sname"));
                user.setSclass(rs.getString("sclass"));
                user.setSex(rs.getString("sex"));
                user.setIdentity(rs.getString("identity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
    //根据用户名查找学生，老师数据（个人中心）

    public int deleteStudent(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="delete from excuse.stu_user where username=?";
        int count=0;
        try {
            conn= Utils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public int deleteTeacher(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="delete from excuse.teach_user where username=?";
        int count=0;
        try {
            conn= Utils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    //删除学生，教师

    public static List<User> getStudentByCondition(String condition) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        try {
            conn = Utils.getConnection();
            String sql = "SELECT * FROM excuse.stu_user WHERE CONCAT_WS(',',username,password,sname,sclass,sex,identity) LIKE ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + condition + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSname(rs.getString("sname"));
                user.setSclass(rs.getString("sclass"));
                user.setSex(rs.getString("sex"));
                user.setIdentity(rs.getString("identity"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
    public static List<User> getTeacherByCondition(String condition) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        try {
            conn = Utils.getConnection();
            String sql = "SELECT * FROM excuse.teach_user WHERE CONCAT_WS(',',username,password,sname,sclass,sex,identity) LIKE ?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + condition + "%");
            rs = ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSname(rs.getString("sname"));
                user.setSclass(rs.getString("sclass"));
                user.setSex(rs.getString("sex"));
                user.setIdentity(rs.getString("identity"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
    //根据条件名查找学生，老师数据（个人中心）

    public static String getTeacher_class(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT sclass FROM excuse.teach_user WHERE username=?;";
        conn= Utils.getConnection();
        ps=conn.prepareStatement(sql);
        String teacher_class = null;

        ps.setString(1, username);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            teacher_class = rs.getString("sclass");
        }
        return teacher_class;
    }
    //根据用户名查找班级（根据班级查看该班级的请假条）

    public static String getStudent_class(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = " SELECT sclass FROM excuse.stu_user WHERE username=?;";
        conn= Utils.getConnection();
        ps=conn.prepareStatement(sql);
        String student_class = null;

        ps.setString(1, username);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            student_class = rs.getString("sclass");
        }
        return student_class;
    }
    public static String getStudent_name(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = " SELECT sname FROM excuse.stu_user WHERE username=?;";
        conn= Utils.getConnection();
        ps=conn.prepareStatement(sql);
        String student_name = null;

        ps.setString(1, username);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            student_name = rs.getString("sname");
        }
        return student_name;
    }
    //修改或插入时默认值不可修改
}
