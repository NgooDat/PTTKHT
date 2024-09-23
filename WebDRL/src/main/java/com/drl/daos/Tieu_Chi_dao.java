package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Tieu_Chi;

public class Tieu_Chi_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay tat ca tieu chi
	public List<Tieu_Chi> getAllTieuChi() {
	    List<Tieu_Chi> lstTieuChi = new ArrayList<>();
	    String sql = "SELECT * FROM Tieu_Chi";
	    
	    try {
	        conn = new DBConnect().getConnection();   // Kết nối cơ sở dữ liệu
	        ps = conn.prepareStatement(sql);          // Chuẩn bị câu lệnh SQL
	        rs = ps.executeQuery();                   // Thực thi câu lệnh SQL và nhận kết quả

	        // Lặp qua kết quả và thêm vào danh sách lstTieuChi
	        while (rs.next()) {
	            Tieu_Chi tc = new Tieu_Chi();
	            tc.setId(rs.getInt("ID"));             // Lấy ID của tiêu chí
	            tc.setNoiDung(rs.getString("noiDung")); // Lấy nội dung của tiêu chí
	            tc.setTongDiem(rs.getInt("TongDiem"));  // Lấy tổng điểm của tiêu chí

	            lstTieuChi.add(tc);                    // Thêm đối tượng Tieu_Chi vào danh sách
	        }

	    } catch (Exception e) {
	        e.printStackTrace();  // Bắt lỗi nếu có
	    } 
	    return lstTieuChi;  // Trả về danh sách tiêu chí
	}
	
	//lay thong tin tieu chi theo id
	public Tieu_Chi getTieuChi_by_id(int id) {
	    Tieu_Chi tc = null;
	    String sql = "SELECT * FROM Tieu_Chi where ?";
	    
	    try {
	        conn = new DBConnect().getConnection();   // Kết nối cơ sở dữ liệu
	        ps = conn.prepareStatement(sql);          // Chuẩn bị câu lệnh SQL
	        ps.setInt(1, id);
	        rs = ps.executeQuery();                   // Thực thi câu lệnh SQL và nhận kết quả

	        // Lặp qua kết quả và thêm vào danh sách lstTieuChi
	        if (rs.next()) {
	            tc = new Tieu_Chi();
	            tc.setId(rs.getInt("ID"));             // Lấy ID của tiêu chí
	            tc.setNoiDung(rs.getString("noiDung")); // Lấy nội dung của tiêu chí
	            tc.setTongDiem(rs.getInt("TongDiem"));  // Lấy tổng điểm của tiêu chí
	        }

	    } catch (Exception e) {
	        e.printStackTrace();  // Bắt lỗi nếu có
	    } 
	    return tc;  // Trả về danh sách tiêu chí
	}

}
