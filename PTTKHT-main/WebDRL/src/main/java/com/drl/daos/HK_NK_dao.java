package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.HK_NK;
import java.sql.SQLException;

public class HK_NK_dao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //lay tat ca hknk
    public List<HK_NK> getAllHK_NK() {
        List<HK_NK> dsHK_NK = new ArrayList<>();
        String query = "SELECT * FROM HK_NK";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HK_NK hknk = new HK_NK(rs.getInt("ID"),
                                       rs.getString("nienKhoa"),
                                       rs.getInt("hocKy"),
                                       rs.getInt("xet"));
                dsHK_NK.add(hknk);
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return dsHK_NK;
    }
    
    //lay hknk theo id
    public HK_NK getHK_NK_by_ID(int id) {
        HK_NK hknk = null;
        String query = "SELECT * FROM HK_NK WHERE ID = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                hknk = new HK_NK(rs.getInt("ID"),
                                 rs.getString("nienKhoa"),
                                 rs.getInt("hocKy"),
                                 rs.getInt("xet"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return hknk;
    }

    //lay ds hknk theo nien khoa
    public List<HK_NK> getHK_NK_by_NienKhoa(String nienKhoa) {
        List<HK_NK> dsHK_NK = new ArrayList<>();
        String query = "SELECT * FROM HK_NK WHERE nienKhoa = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, nienKhoa);
            rs = ps.executeQuery();
            while (rs.next()) {
                HK_NK hknk = new HK_NK(rs.getInt("ID"),
                                       rs.getString("nienKhoa"),
                                       rs.getInt("hocKy"),
                                       rs.getInt("xet"));
                dsHK_NK.add(hknk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return dsHK_NK;
    }
    
    //them hknk
    public boolean addHK_NK(HK_NK hknk) {
        String query = "INSERT INTO HK_NK (nienKhoa, hocKy, xet) VALUES (?, ?, ?)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, hknk.getNienKhoa());
            ps.setInt(2, hknk.getHocKy());
            ps.setInt(3, hknk.getXet());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    //cap nhat hknk
    public boolean updateHK_NK(HK_NK hknk) {
        String query = "UPDATE HK_NK SET nienKhoa = ?, hocKy = ?, xet = ? WHERE ID = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, hknk.getNienKhoa());
            ps.setInt(2, hknk.getHocKy());
            ps.setInt(3, hknk.getXet());
            ps.setInt(4, hknk.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    //xoa hknk
    public boolean deleteHK_NK(int id) {
        String query = "DELETE FROM HK_NK WHERE ID = ?";
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

