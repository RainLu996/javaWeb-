package com.lujun61.dao;

import com.lujun61.entity.Users;
import com.lujun61.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public UserDAO() {
    }

    /**
     * @param user 待存入数据库中的用户信息
     * @return int 此方法的返回结果：如果为1，则插入数据成功；为0，则插入数据失败
     * @description 用户注册
     * @author Jun Lu
     * @date 2021-09-20 21:55:58
     */
    public int add(Users user) {
        String sql = "insert into table_userinfo(userName, password, email, sex) values(?, ?, ?, ?)";
        PreparedStatement ps = null;
        Connection conn = null;
        int result = 0;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getSex());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
        return result;
    }

    /**
     * @return java.util.List<com.lujun61.entity.Users> 返回查询结果集
     * @description 连接数据库查询用户信息
     * @author Jun Lu
     * @date 2021-09-21 16:57:58
     */
    public List<Users> query() {
        String sql = "select * from table_userinfo";
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Users user = null;
        List<Users> eleList = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String sex = rs.getString("sex");
                user = new Users(userID, userName, password, email, sex);
                eleList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return eleList;
    }

    /**
     * @param userID 定位用户的唯一标识
     * @return int 用户信息删除成功返回1；删除失败返回0
     * @description 用于操作数据库，删除指定用户信息
     * @author Jun Lu
     * @date 2021-09-21 17:11:17
     */
    public int delete(String userID) {
        String sql = "delete from table_userinfo where userID=?";
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(userID));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
        return result;
    }

    /**
     * @param userName 用户名
     * @param password 用户密码
     * @return boolean 若用户登录信息在数据库中存在，即返回true；否则返回false
     * @description 用户登录界面
     * @author Jun Lu
     * @date 2021-09-21 23:15:27
     */
    public boolean login(String userName, String password) {
        String sql = "select * from table_userinfo where userName=? and password=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return false;
    }
}
