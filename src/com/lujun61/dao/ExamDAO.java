package com.lujun61.dao;

import com.lujun61.entity.Exam;
import com.lujun61.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {
    /**
     * @param exam 传入过来的需要添加至数据库的Exam对象
     * @return int 添加试题成功，返回1；失败，返回0
     * @description 向数据库中添加试题
     * @author Jun Lu
     * @date 2021-09-22 10:23:49
     */
    public int add(Exam exam) {
        String sql = "insert into table_exam(title,optionA,optionB,optionC,optionD,answer) " +
                "values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, exam.getTitle());
            ps.setString(2, exam.getOptionA());
            ps.setString(3, exam.getOptionB());
            ps.setString(4, exam.getOptionC());
            ps.setString(5, exam.getOptionD());
            ps.setString(6, exam.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
        return result;
    }

    /**
     * @return java.util.List<com.lujun61.entity.Exam> 返回查询结果集
     * @description 查询数据库中的所有习题
     * @author Jun Lu
     * @date 2021-09-22 10:47:58
     */
    public List<Exam> query() {
        String sql = "select * from table_exam";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Exam> list = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer examID = rs.getInt("examID");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                list.add(new Exam(examID, title, optionA, optionB, optionC, optionD, answer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return list;
    }
}
