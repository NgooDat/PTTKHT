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
	    String sql = "SELECT * FROM Tieu_Chi where ID= ?";
	    
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
	
	// thêm tiêu chí 
	public boolean addTieuChi(Tieu_Chi tc) {
	    String sql = "INSERT INTO Tieu_Chi (noiDung, TongDiem) VALUES (?, ?)";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, tc.getNoiDung());    
	        ps.setInt(2, tc.getTongDiem());      
	        int rowsInserted = ps.executeUpdate();
	        
	        if (rowsInserted > 0) {
	            return true;  // Thêm thành công
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return false;  // Thêm thất bại
	}
	
	// xóa tiêu chí
	public boolean deleteTieuChi(int id) {
	    String sql = "DELETE FROM Tieu_Chi WHERE ID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);  
	        int rowsDeleted = ps.executeUpdate();
	        
	        if (rowsDeleted > 0) {
	            return true;  // Xóa thành công
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return false;  // Xóa thất bại
	}
	
	// cap nhat tieu chi
	public boolean updateTieuChi(Tieu_Chi tc) {
	    String sql = "UPDATE Tieu_Chi SET noiDung = ?, TongDiem = ? WHERE ID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, tc.getNoiDung());    
	        ps.setInt(2, tc.getTongDiem());      
	        ps.setInt(3, tc.getId());            
	        int rowsUpdated = ps.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            return true;  // Cập nhật thành công
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return false;  // Cập nhật thất bại
	}
}
//@@te

