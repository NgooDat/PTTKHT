package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Khoa_Hoc;

public class Khoa_Hoc_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy khóa học theo ID
    public Khoa_Hoc getKhoaHoc_by_ID(int id) {
        Khoa_Hoc kh = null;
        String qr = "SELECT * FROM Khoa_Hoc WHERE ID = ?";

        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            ps.setLong(1, id);  // Đặt giá trị ID vào câu truy vấn
            rs = ps.executeQuery();

            if (rs.next()) {
                // Giả sử Khoa_Hoc có constructor gồm các tham số: ID, namBD, namKT
                kh = new Khoa_Hoc(rs.getInt("ID"),
                        rs.getInt("namBD"),
                        rs.getInt("namKT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }
    
    //lấy tất cả khóa học
    public List<Khoa_Hoc> getAllKhoaHoc() {
        List<Khoa_Hoc> dsKhoaHoc = new ArrayList<>();
        String query = "SELECT * FROM Khoa_Hoc";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Khoa_Hoc kh = new Khoa_Hoc(rs.getInt("ID"),
                                           rs.getInt("namBD"),
                                           rs.getInt("namKT"));
                dsKhoaHoc.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return dsKhoaHoc;
    }

    //thêm khóa học
    public boolean addKhoaHoc(Khoa_Hoc khoaHoc) {
        String query = "INSERT INTO Khoa_Hoc (namBD, namKT) VALUES (?, ?)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, khoaHoc.getNamBD());
            ps.setInt(2, khoaHoc.getNamKT());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    //cập nhật khóa học
    public boolean updateKhoaHoc(Khoa_Hoc khoaHoc) {
        String query = "UPDATE Khoa_Hoc SET namBD = ?, namKT = ? WHERE ID = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, khoaHoc.getNamBD());
            ps.setInt(2, khoaHoc.getNamKT());
            ps.setInt(3, khoaHoc.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    //xóa khóa học
    public boolean deleteKhoaHoc(int id) {
        String query = "DELETE FROM Khoa_Hoc WHERE ID = ?";
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
