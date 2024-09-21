package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Giang_Vien;

public class Giang_Vien_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	// Lấy thông tin giảng viên theo ID
	public Giang_Vien getGiangVien_by_ID(String id) {
	    Giang_Vien giangVien = null;
	    String qr = "SELECT * FROM Giang_Vien WHERE ID = ?";
	    
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(qr);
	        ps.setString(1, id);  // Đặt giá trị ID vào câu truy vấn
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            giangVien = new Giang_Vien(rs.getString("ID"),
	                                       rs.getString("hoTen"),
	                                       rs.getString("gioiTinh"),
	                                       rs.getDate("ngaySinh"),
	                                       rs.getString("sdt"),
	                                       rs.getString("email"),
	                                       rs.getString("diaChi"),
	                                       rs.getString("queQuan"),
	                                       rs.getInt("Tai_KhoanID"),
	                                       rs.getString("KhoaID"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return giangVien;
	}
	
	//lấy toàn bộ giảng viên
	public List<Giang_Vien> getAllGiangVien() {
		List<Giang_Vien> lgv =new ArrayList<Giang_Vien>();
		String qr="select * from Giang_Vien";
		try {
			conn = new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			rs=ps.executeQuery();
			while(rs.next()) {
				lgv.add(new Giang_Vien(rs.getString("ID"),
	                                       rs.getString("hoTen"),
	                                       rs.getString("gioiTinh"),
	                                       rs.getDate("ngaySinh"),
	                                       rs.getString("sdt"),
	                                       rs.getString("email"),
	                                       rs.getString("diaChi"),
	                                       rs.getString("queQuan"),
	                                       rs.getInt("Tai_KhoanID"),
	                                       rs.getString("KhoaID")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lgv;
	}
	
	//them giang vien
	public boolean addGiangVien(Giang_Vien gv) {
		boolean isSucess =false;
		String qr="INSERT INTO Giang_Vien (ID,hoTen, gioiTinh, ngaySinh, sdt, email, diaChi, queQuan, Tai_KhoanID, KhoaID) "
				+ "(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			ps.setString(1, gv.getHoTen());
			ps.setString(2, gv.getGioiTinh());
			ps.setDate(3, new java.sql.Date(gv.getNgaySinh().getTime()));
			ps.setString(4, gv.getSdt());
			ps.setString(5, gv.getEmail());
			ps.setString(6, gv.getDiaChi());
			ps.setString(7, gv.getQueQuan());
			ps.setInt(8, gv.getTaiKhoanID());
			ps.setString(9, gv.getKhoaID());
			ps.setString(10, gv.getId());
			//thuc hien va kiem tra
			isSucess=ps.executeUpdate()>0;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return isSucess;
	}

}
