package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.CT_TC;

public class CT_TC_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay ds chi tiet tieu chi theo tieuChiID
	public List<CT_TC> getCT_TC_by_tieuChiID(int id){
		List<CT_TC> lst=new ArrayList<CT_TC>();
		String qr="select * from CT_TC where ?";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				CT_TC ct=new CT_TC(rs.getInt("ID"),
								rs.getString("noiDung"), 
								rs.getInt("diemTD"), 
								rs.getInt("Tieu_ChiID"));
				lst.add(ct);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}
	//lay thong tin CT_TC theo id
	
}
