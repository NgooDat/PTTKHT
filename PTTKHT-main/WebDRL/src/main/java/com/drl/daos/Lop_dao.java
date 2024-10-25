package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Lop;
public class Lop_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay danh sach lop
	public List<Lop> getAllLop(){
		List<Lop> lsv= new ArrayList<>() ;
		String qr="select * from Lop";
		try {
			 conn = new DBConnect().getConnection();
		     	ps = conn.prepareStatement(qr);
		        rs = ps.executeQuery();
		        while (rs.next()) {
		            lsv.add(new Lop(rs.getString("ID"),
		                            rs.getInt("Khoa_HocID"),
		                            rs.getString("KhoaID"),
		                            rs.getString("Giang_VienID"),
		                            rs.getString("ten")));
		        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsv;
	}
	
	// Lấy danh sách lớp theo KhoaID
	public List<Lop> getLop_by_KhoaID(String khoaID) {
	    List<Lop> dsLop = new ArrayList<>();
	    String qr = "SELECT * FROM Lop WHERE KhoaID = ?";
	    
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(qr);
	        ps.setString(1, khoaID);  // Đặt giá trị KhoaID vào câu truy vấn
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            dsLop.add(new Lop(rs.getString("ID"),
	                              rs.getInt("Khoa_HocID"),
	                              rs.getString("KhoaID"),
	                              rs.getString("Giang_VienID"),
	                              rs.getString("ten")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return dsLop;
	}
	
	//lay lop theo id
	public Lop getLop_by_ID(String id) {
	    Lop lop = null;
	    String sql = "SELECT * FROM Lop WHERE ID = ?";
	    
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, id);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            lop = new Lop(
	                rs.getString("ID"),            // Lấy giá trị cột ID
	                rs.getInt("Khoa_HocID"),       // Lấy giá trị cột Khoa_HocID
	                rs.getString("KhoaID"),        // Lấy giá trị cột KhoaID
	                rs.getString("Giang_VienID"),  // Lấy giá trị cột Giang_VienID
	                rs.getString("ten")            // Lấy giá trị cột tên lớp
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return lop;  // Trả về đối tượng Lop hoặc null nếu không tìm thấy
	}


	// Hàm thêm một lớp vào bảng Lop
	public boolean addLop(Lop lop) {
	    String qr = "INSERT INTO Lop (ID, Khoa_HocID, KhoaID, Giang_VienID, ten) VALUES (?, ?, ?, ?, ?)";
	    boolean isSuccess = false;

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(qr);
	        
	        // Đặt các tham số cho câu truy vấn
	        ps.setString(1, lop.getId());               // Đặt giá trị ID của lớp
	        ps.setInt(2, lop.getKhoaHocID());          // Đặt giá trị Khoa_HocID
	        ps.setString(3, lop.getKhoaID());           // Đặt giá trị KhoaID
	        ps.setString(4, lop.getGiangVienID());        // Đặt giá trị Giang_VienID
	        ps.setString(5, lop.getTen());              // Đặt tên của lớp
	        isSuccess = ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return isSuccess;
	}
	
	//cap nhat thong tin cho lop
	public boolean updateLop(Lop lop) {
	    String qr = "UPDATE Lop SET Khoa_HocID = ?, KhoaID = ?, Giang_VienID = ?, ten =  ? WHERE ID = ?";
	    boolean isSuccess = false;

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(qr);
	        
	        // Đặt các tham số cho câu truy vấn
	        ps.setInt(1, lop.getKhoaHocID());          // Đặt giá trị Khoa_HocID
	        ps.setString(2, lop.getKhoaID());           // Đặt giá trị KhoaID
	        ps.setString(3, lop.getGiangVienID());        // Đặt giá trị Giang_VienID
	        ps.setString(4, lop.getTen());              // Đặt tên của lớp
	        ps.setString(5, lop.getId());               // Đặt giá trị ID của lớp
	        isSuccess = ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return isSuccess;
	}
	
	// xoa lop theo id
	public boolean deleteLop_by_ID(String id) {
	    String sql = "DELETE FROM Lop WHERE ID = ?";
	    boolean rowDeleted = false;
	    
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, id);
	        int rowsAffected = ps.executeUpdate();
	        rowDeleted = rowsAffected > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return rowDeleted;  // Trả về true nếu xóa thành công, ngược lại là false
	}

}
//te@@
