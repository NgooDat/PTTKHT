package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Lop;
import java.sql.SQLException;

public class Lop_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lay danh sach lop
    public ArrayList<Lop> getAllLop() {
        ArrayList<Lop> lsv = new ArrayList<>();
        String qr = "select * from Lop";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Giả sử Lop có constructor gồm các tham số: ID, Khoa_HocID, KhoaID, Giang_VienID, ten
                lsv.add(new Lop(rs.getString("ID"),
                        rs.getInt("Khoa_HocID"),
                        rs.getString("KhoaID"),
                        rs.getString("Giang_VienID"),
                        rs.getString("ten")));
            }
        } catch (ClassNotFoundException | SQLException e) {
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
                // Giả sử Lop có constructor gồm các tham số: ID, Khoa_HocID, KhoaID, Giang_VienID, ten
                dsLop.add(new Lop(rs.getString("ID"),
                        rs.getInt("Khoa_HocID"),
                        rs.getString("KhoaID"),
                        rs.getString("Giang_VienID"),
                        rs.getString("ten")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return dsLop;
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

            // Thực thi câu lệnh và kiểm tra xem có thêm thành công không
            isSuccess = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return isSuccess;
    }

}
