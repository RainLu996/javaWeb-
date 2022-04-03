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
    public ExamDAO() {
    }

    /**
     * @param exam 传入过来的需要添加至数据库的Exam对象
     * @return int 添加试题成功，返回1；失败，返回0
     * @description 向数据库中添加试题
     * @author Jun Lu
     * @date 2021-09-22 10:23:49
     */
    public int add(Exam exam) {
        String sql = "insert into userinfo.table_exam(title,optionA,optionB,optionC,optionD,answer) " +
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
        String sql = "select * from userinfo.table_exam";
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

    /**
     * @param id 浏览器参数都是String类型
     * @return int 试题信息删除成功返回1；删除失败返回0
     * @description 用于操作数据库，删除指定试题信息
     * @author Jun Lu
     * @date 2021-10-03 14:01:17
     */
    public int deleteExam(String id) {
        String sql = "delete from userinfo.table_exam where examID=?";
        int result = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @param id 需要查询的试题ID
     * @return com.lujun61.entity.Exam 返回被查询的试题的所有信息
     * @description 通过试题编号查询试题详细信息
     * @author Jun Lu
     * @date 2021-10-03 15:14:32
     */
    public Exam findByID(String id) {
        String sql = "select * from userinfo.table_exam where examID=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Exam exam = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer examID = rs.getInt("examID");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                exam = new Exam(examID, title, optionA, optionB, optionC, optionD, answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return exam;
    }

    /**
     * @param exam 待更新的试题
     * @return int 试题信息更新成功返回1；更新失败返回0
     * @description 更新试题信息
     * @author Jun Lu
     * @date 2021-10-03 16:33:25
     */
    public int updateExam(Exam exam) {
        String sql = "update userinfo.table_exam set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where examID=?";
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
            ps.setInt(7, exam.getExamID());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
        return result;
    }

    public List<Exam> randExam() {
        //rand()随机返回0~1之间的小数；但是在mysql中，rand()如果出现在order by之后，将随机返回0~9之间的数字
        //如果order by返回的数字大于了数据表中的最大列数，将自动转换为1
        String sql = "select * from userinfo.table_exam order by rand() limit 0,4";

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
