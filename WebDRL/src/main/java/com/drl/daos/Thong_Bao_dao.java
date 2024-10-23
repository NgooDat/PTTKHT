package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Thong_Bao;

public class Thong_Bao_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay tat ca thong bao
	public List<Thong_Bao> getAllThongBao() {
	    List<Thong_Bao> dsThongBao = new ArrayList<>();
	    String query = "SELECT * FROM Thong_Bao";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Thong_Bao tb = new Thong_Bao(rs.getInt("id"),
	                                         rs.getDate("ngayBD"),
	                                         rs.getDate("ngayKT_SV"),
	                                         rs.getDate("ngayKT_CS"),
	                                         rs.getDate("ngayKT_CV"),
	                                         rs.getDate("ngayKT_Khoa"),
	                                         rs.getInt("HK_NKID"));
	            dsThongBao.add(tb);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return dsThongBao;
	}
	
	//lay thong bao theo id
	public Thong_Bao getThongBao_by_ID(int id) {
	    Thong_Bao thongBao = null;
	    String query = "SELECT * FROM Thong_Bao WHERE id = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            thongBao = new Thong_Bao(rs.getInt("id"),
	                                     rs.getDate("ngayBD"),
	                                     rs.getDate("ngayKT_SV"),
	                                     rs.getDate("ngayKT_CS"),
	                                     rs.getDate("ngayKT_CV"),
	                                     rs.getDate("ngayKT_Khoa"),
	                                     rs.getInt("HK_NKID"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return thongBao;
	}
	
	//them thong bao
	public boolean addThongBao(Thong_Bao tb) {
	    String query = "INSERT INTO Thong_Bao (ngayBD, ngayKT_SV, ngayKT_CS, ngayKT_CV, ngayKT_Khoa, HK_NKID) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setDate(1, new java.sql.Date(tb.getNgayBD().getTime()));
	        ps.setDate(2, new java.sql.Date(tb.getNgayKT_SV().getTime()));
	        ps.setDate(3, new java.sql.Date(tb.getNgayKT_CS().getTime()));
	        ps.setDate(4, new java.sql.Date(tb.getNgayKT_CV().getTime()));
	        ps.setDate(5, new java.sql.Date(tb.getNgayKT_Khoa().getTime()));
	        ps.setInt(6, tb.getHkNkID());
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return false;
	}
	
	//cap nhat thong bao
	public boolean updateThongBao(Thong_Bao tb) {
	    String query = "UPDATE Thong_Bao SET ngayBD = ?, ngayKT_SV = ?, ngayKT_CS = ?, ngayKT_CV = ?, ngayKT_Khoa = ?, HK_NKID = ? WHERE id = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setDate(1, new java.sql.Date(tb.getNgayBD().getTime()));
	        ps.setDate(2, new java.sql.Date(tb.getNgayKT_SV().getTime()));
	        ps.setDate(3, new java.sql.Date(tb.getNgayKT_CS().getTime()));
	        ps.setDate(4, new java.sql.Date(tb.getNgayKT_CV().getTime()));
	        ps.setDate(5, new java.sql.Date(tb.getNgayKT_Khoa().getTime()));
	        ps.setInt(6, tb.getHkNkID());
	        ps.setInt(7, tb.getId());
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return false;
	}
	
	//xoa thong bao
	public boolean deleteThongBao(int id) {
	    String query = "DELETE FROM Thong_Bao WHERE id = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return false;
	}


}
