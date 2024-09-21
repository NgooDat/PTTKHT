package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Sinh_Vien;

public class Sinh_Vien_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay danh sach sinh vien
	public List<Sinh_Vien> getAllSV(){
		List<Sinh_Vien> lsv= new ArrayList<>() ;
		String qr="select * from Sinh_Vien";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			rs=ps.executeQuery();
			while(rs.next()) {
				Sinh_Vien sv = new Sinh_Vien(
	                    rs.getString("ID"),       // ID
	                    rs.getString("hoTen"),    // hoTen
	                    rs.getString("gioiTinh"), // gioiTinh
	                    rs.getDate("ngaySinh"),   // ngaySinh
	                    rs.getString("sdt"),      // sdt
	                    rs.getString("diaChi"),   // diaChi
	                    rs.getString("email"),    // email
	                    rs.getString("queQuan"),  // queQuan
	                    rs.getString("LopID"),    // LopID
	                    rs.getInt("Tai_KhoanID")  // Tai_KhoanID
	                );
	                lsv.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsv;
	}
	
	//lap danh sach sinh vien theo lop
	public List<Sinh_Vien> getSV_by_LopID(String id){
		List<Sinh_Vien> lsv= new ArrayList<>() ;
		String qr="select * from Sinh_Vien where LopID=?";
		try {
			conn=new DBConnect().getConnection();
			ps=conn.prepareStatement(qr);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Sinh_Vien sv = new Sinh_Vien(
	                    rs.getString("ID"),       // ID
	                    rs.getString("hoTen"),    // hoTen
	                    rs.getString("gioiTinh"), // gioiTinh
	                    rs.getDate("ngaySinh"),   // ngaySinh
	                    rs.getString("sdt"),      // sdt
	                    rs.getString("diaChi"),   // diaChi
	                    rs.getString("email"),    // email
	                    rs.getString("queQuan"),  // queQuan
	                    rs.getString("LopID"),    // LopID
	                    rs.getInt("Tai_KhoanID")  // Tai_KhoanID
	                );
	                lsv.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsv;
	}
	
	//lay sinh vien dang nhap
	public Sinh_Vien getSV_by_email(String email){	
	Sinh_Vien lsv= null ;
	String qr="select * from Sinh_Vien where email=?";
	try {
		conn=new DBConnect().getConnection();
		ps=conn.prepareStatement(qr);
		ps.setString(1, email);
		rs=ps.executeQuery();
		while(rs.next()) {
			lsv = new Sinh_Vien(
                    rs.getString("ID"),       // ID
                    rs.getString("hoTen"),    // hoTen
                    rs.getString("gioiTinh"), // gioiTinh
                    rs.getDate("ngaySinh"),   // ngaySinh
                    rs.getString("sdt"),      // sdt
                    rs.getString("diaChi"),   // diaChi
                    rs.getString("email"),    // email
                    rs.getString("queQuan"),  // queQuan
                    rs.getString("LopID"),    // LopID
                    rs.getInt("Tai_KhoanID")  // Tai_KhoanID
                );
		}
		} catch (Exception e) {
		// TODO: handle exception
		}
		return lsv;
	}
	
}
