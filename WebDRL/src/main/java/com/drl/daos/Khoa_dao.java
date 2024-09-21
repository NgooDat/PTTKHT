package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Khoa;

public class Khoa_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	// Lấy khoa theo ID
		public Khoa getKhoa_by_ID(String id) {
			Khoa khoa = null;
		    String qr = "SELECT * FROM Khoa WHERE ID = ?";
		    
		    try {
		        conn = new DBConnect().getConnection();
		        ps = conn.prepareStatement(qr);
		        ps.setString(1, id);  // Đặt giá trị ID vào câu truy vấn
		        rs = ps.executeQuery();
		        
		        if (rs.next()) {
		            // Giả sử Khoa có constructor gồm các tham số: ID, ten, ngayTL
		            khoa = new Khoa(rs.getString("ID"),
		                            rs.getString("ten"),
		                            rs.getDate("ngayTL"),
		                            rs.getInt("status"));
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return khoa;
		}
		// Lấy danh sách tất cả các khoa
		public List<Khoa> getAllKhoa() {
		    List<Khoa> dsKhoa = new ArrayList<>();
		    String qr = "SELECT * FROM Khoa";
		    
		    try {
		        conn = new DBConnect().getConnection();
		        ps = conn.prepareStatement(qr);
		        rs = ps.executeQuery();
		        
		        while (rs.next()) {
		            dsKhoa.add(new Khoa(rs.getString("ID"),
		                                rs.getString("ten"),
		                                rs.getDate("ngayTL"),
		                                rs.getInt("status")));
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
		    return dsKhoa;
		}
		
		// Hàm thêm một khoa vào bảng Khoa
		public boolean addKhoa(Khoa khoa) {
		    String qr = "INSERT INTO Khoa (ID, ten, ngayTL, status) VALUES (?, ?, ?, ?)";
		    boolean isSuccess = false;

		    try {
		        conn = new DBConnect().getConnection();
		        ps = conn.prepareStatement(qr);
		        
		        // Đặt các tham số cho câu truy vấn
		        ps.setString(1, khoa.getId());           // Đặt giá trị ID của khoa
		        ps.setString(2, khoa.getTen());          // Đặt tên của khoa
		        ps.setDate(3, new java.sql.Date(khoa.getNgayTL().getTime()));  // Đặt ngày thành lập
		        ps.setInt(4, khoa.getStatus());          // Đặt trạng thái (status)

		        // Thực thi câu lệnh và kiểm tra xem có thêm thành công không
		        isSuccess = ps.executeUpdate() > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return isSuccess;
		}


}
