package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.DRL;

public class DRL_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//lay DRL theo mã sv
	public List<DRL> getDRL_by_SinhVienID(String id) {
	    List<DRL> drlList = new ArrayList<>();
	    String query = "SELECT * FROM DRL WHERE Sinh_VienID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, id);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            DRL drl = new DRL(rs.getInt("ID"),
	                              rs.getInt("diemSV"),
	                              rs.getInt("diemCS"),
	                              rs.getInt("diemCV"),
	                              rs.getInt("status"),
	                              rs.getString("Sinh_VienID"),
	                              rs.getInt("HK_NKID"));
	            drlList.add(drl);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return drlList;
	}
	
	//lay drl theo HK_NKID
	public List<DRL> getDRL_by_HK_NKID(int hkNkID) {
	    List<DRL> drlList = new ArrayList<>();
	    String query = "SELECT * FROM DRL WHERE HK_NKID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, hkNkID);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            DRL drl = new DRL(rs.getInt("ID"),
	                              rs.getInt("diemSV"),
	                              rs.getInt("diemCS"),
	                              rs.getInt("diemCV"),
	                              rs.getInt("status"),
	                              rs.getString("Sinh_VienID"),
	                              rs.getInt("HK_NKID"));
	            drlList.add(drl);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return drlList;
	}

	//lay DRL theo status
	public List<DRL> getDRL_by_status(int status) {
	    List<DRL> drlList = new ArrayList<>();
	    String query = "SELECT * FROM DRL WHERE status = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, status);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            DRL drl = new DRL(rs.getInt("ID"),
	                              rs.getInt("diemSV"),
	                              rs.getInt("diemCS"),
	                              rs.getInt("diemCV"),
	                              rs.getInt("status"),
	                              rs.getString("Sinh_VienID"),
	                              rs.getInt("HK_NKID"));
	            drlList.add(drl);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return drlList;
	}

	//lay drl theo id
	public DRL getDRL_by_ID(int id) {
	    DRL drl = null;
	    String query = "SELECT * FROM DRL WHERE ID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            drl = new DRL(rs.getInt("ID"),
	                          rs.getInt("diemSV"),
	                          rs.getInt("diemCS"),
	                          rs.getInt("diemCV"),
	                          rs.getInt("status"),
	                          rs.getString("Sinh_VienID"),
	                          rs.getInt("HK_NKID"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return drl;
	}

	//them drl
	public boolean addDRL(DRL drl) {
	    String query = "INSERT INTO DRL (diemSV, diemCS, diemCV, status, Sinh_VienID, HK_NKID) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, drl.getDiemSV());
	        ps.setInt(2, drl.getDiemCS());
	        ps.setInt(3, drl.getDiemCV());
	        ps.setInt(4, drl.getStatus());
	        ps.setString(5, drl.getSinhVienID());
	        ps.setInt(6, drl.getHkNkID());
	        int rowsInserted = ps.executeUpdate();
	        return rowsInserted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	}
	
	//cập nhật thông tin ( không cập nhật điểm )
	public boolean updateDRL(DRL drl) {
	    String query = "UPDATE DRL SET Sinh_VienID = ?, HK_NKID = ?, status = ? WHERE ID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, drl.getSinhVienID());
	        ps.setInt(2, drl.getHkNkID());
	        ps.setInt(3, drl.getStatus());
	        ps.setInt(4, drl.getId());

	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	}
	//xóa drl
	public boolean deleteDRL(int id) {
	    String query = "DELETE FROM DRL WHERE ID = ?";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);

	        int rowsDeleted = ps.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	}

}
//te@@
