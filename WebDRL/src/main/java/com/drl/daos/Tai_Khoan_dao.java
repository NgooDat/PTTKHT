package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.drl.models.Tai_Khoan;

public class Tai_Khoan_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay thong tin tai khoan theo email
	public Tai_Khoan getTaiKhoan_by_email(String email) {
		Tai_Khoan tk=null;
		String qr="select * from Tai_Khoan where email=?";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				tk=new Tai_Khoan(rs.getInt("ID"),
								rs.getString("email"),
								rs.getString("password"),
								rs.getInt("status"),
								rs.getInt("RulesID"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tk;
	}
}
