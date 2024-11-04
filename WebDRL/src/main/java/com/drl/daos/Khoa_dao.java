package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.drl.models.Khoa;
import java.sql.SQLException;

public class Khoa_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy khoa theo ID
    public Khoa getKhoa_by_ID(String id) {
        Khoa khoa = null;
        String qr = "SELECT * FROM Khoa WHERE ID = ?";

        try {
            conn = DBConnect.getConnection();
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
        } catch (SQLException e) {
        }
        return khoa;
    }
    // Lấy danh sách tất cả các khoa

    public ArrayList<Khoa> getAllKhoa() {
        ArrayList<Khoa> dsKhoa = new ArrayList<>();
        String qr = "SELECT * FROM Khoa";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
            rs = ps.executeQuery();

            while (rs.next()) {
                dsKhoa.add(new Khoa(rs.getString("ID"),
                        rs.getString("ten"),
                        rs.getDate("ngayTL"),
                        rs.getInt("status")));
            }
        } catch (SQLException e) {
        }
        return dsKhoa;
    }

    public boolean isKhoaExist(String khoaID) {
        String qr = "SELECT COUNT(*) FROM Khoa WHERE ID = ?";
        boolean exists = false;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, khoaID.toLowerCase());
            rs = ps.executeQuery();

            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            // In lỗi ra để dễ dàng kiểm tra lỗi trong quá trình phát triển
            
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return exists;
    }

    // Hàm thêm một khoa vào bảng Khoa
    public boolean addKhoa(Khoa khoa) {
        String qr = "INSERT INTO Khoa (ID, ten, ngayTL, status) VALUES (?, ?, ?, ?)";
        boolean isSuccess = false;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);

            // Đặt các tham số cho câu truy vấn
            ps.setString(1, khoa.getId());           // Đặt giá trị ID của khoa
            ps.setString(2, khoa.getTen());          // Đặt tên của khoa
            ps.setDate(3, new java.sql.Date(khoa.getNgayTL().getTime()));  // Đặt ngày thành lập
            ps.setInt(4, khoa.getStatus());          // Đặt trạng thái (status)

            // Thực thi câu lệnh và kiểm tra xem có thêm thành công không
            isSuccess = ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return isSuccess;
    }

    // cap nhat khoa
    public boolean updateKhoa(Khoa khoa) {
        String sql = "UPDATE Khoa SET ten = ?, ngayTL = ?, status = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, khoa.getTen());       // Update the department name
            ps.setDate(2, new java.sql.Date(khoa.getNgayTL().getTime()));  // Update the establishment date
            ps.setInt(3, khoa.getStatus());       // Update the status
            ps.setString(4, khoa.getId());        // Specify the ID of the department to update
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                return true;  // Nếu cập nhật thành công
            }
        } catch (SQLException e) {
        }
        return false;
    }

    // xoa khoa
    public boolean deleteKhoa(String id) {
        String sql = "DELETE FROM Khoa WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);  // Xác định ID của khoa cần xóa
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                return true;  // Nếu xóa thành công
            }
        } catch (SQLException e) {
        }
        return false;  // Nếu xóa thất bại
    }
}
//@@te
