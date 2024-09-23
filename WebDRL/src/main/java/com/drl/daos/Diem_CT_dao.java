package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Diem_CT;

public class Diem_CT_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay danh sach diem cua sv theo cấp đánh giá 
	public List<Diem_CT> getDiem_CT_by_capDG_DRLID(String cap, int id){
		List<Diem_CT> lst =new ArrayList<Diem_CT>();
		String qr="select * from Diem_CT where capDG=? DRLID=?";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			ps.setString(1, cap);
			ps.setInt(2, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Diem_CT d=new Diem_CT(
									rs.getInt("ID"),
									rs.getInt("diem"),
									rs.getString("capDG"),
									rs.getInt("DRLID"),
									rs.getInt("CT_TCID"));
				lst.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}
	public boolean addDiem_CT(Diem_CT d) {
	    boolean result = false;
	    String sql = "INSERT INTO Diem_CT (diem, DRLID, CT_TCID, capDG) VALUES (?, ?, ?, ?)";
	    
	    try {
	        // Kết nối đến cơ sở dữ liệu
	        conn = new DBConnect().getConnection();
	        // Chuẩn bị câu lệnh SQL
	        ps = conn.prepareStatement(sql);
	        
	        // Thiết lập các giá trị cho câu lệnh SQL
	        ps.setInt(1, d.getDiem());        // Điểm của tiêu chí cụ thể
	        ps.setInt(2, d.getDRLID());       // ID của DRL
	        ps.setInt(3, d.getCT_TCID());     // ID của CT_TC
	        ps.setString(4, d.getCapDG());    // Cấp đánh giá (Sinh viên, Cán sự, Cố vấn)
	        
	        // Thực thi câu lệnh
	        result = ps.executeUpdate()>0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return result;  // Trả về kết quả (true nếu thành công, false nếu không)
	}

}
