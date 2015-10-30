package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.entity.Msg;
import com.demo.util.DBUtil;

public class MsgDao {

	public List<Msg>  findAll() throws Exception{
		List<Msg> msgs = new ArrayList<Msg>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement("SELECT *FROM msg");
			rst = prep.executeQuery();
			while(rst.next()){
				Msg m = new Msg();
				m.setId(rst.getInt("id"));
				m.setName(rst.getString("name"));
				m.setEmail(rst.getString("email"));
				m.setSubject(rst.getString("subject"));
				m.setMessage(rst.getString("message"));
				msgs.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return msgs;
		
	}
	
	public void save(Msg m) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement("INSERT INTO msg(name,email,subject,message) "
					+"VALUES(?,?,?,?)");
			prep.setString(1,m.getName() );
			prep.setString(2,m.getEmail() );
			prep.setString(3,m.getSubject() );
			prep.setString(4,m.getMessage() );
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
	}
}
