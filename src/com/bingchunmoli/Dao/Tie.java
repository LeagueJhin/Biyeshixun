package com.bingchunmoli.Dao;

import com.bingchunmoli.Obj.Tiezi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ProjectName: []
 * @Package: [.]
 * @ClassName: []
 * @Description: [一句话描述该类的功能]
 * @Author: []
 * @CreateDate: [ ]
 * @UpdateUser: []
 * @UpdateDate: [ ]
 * @UpdateRemark: [说明本次修改内容]
 */
public class Tie {
    PreparedStatement preparedStatement = null;
    public Tiezi search(Integer tid){
        Connection c = Link.getConnection();
        String sql = "";
        sql = "SELECT * from tiezi where tid = ?";
        Tiezi tiezi = new Tiezi();
        try {
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1,tid);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                tiezi.setArticle(rs.getString("article"));
                tiezi.setTitle(rs.getString("title"));
                tiezi.setData(rs.getString("date"));
                tiezi.setPath(rs.getString("path"));
                tiezi.setUID(rs.getInt("uid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiezi;
    }
}
