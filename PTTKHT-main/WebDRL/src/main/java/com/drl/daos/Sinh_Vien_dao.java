package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Sinh_Vien;
import java.sql.SQLException;

public class Sinh_Vien_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lay danh sach sinh vien
    public List<Sinh_Vien> getAllSV() {
        List<Sinh_Vien> lsv = new ArrayList<>();
        String qr = "select * from Sinh_Vien";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sinh_Vien sv = new Sinh_Vien(
                        rs.getString("ID"), // ID
                        rs.getString("hoTen"), // hoTen
                        rs.getString("gioiTinh"), // gioiTinh
                        rs.getDate("ngaySinh"), // ngaySinh
                        rs.getString("sdt"), // sdt
                        rs.getString("diaChi"), // diaChi
                        rs.getString("email"), // email
                        rs.getString("queQuan"), // queQuan
                        rs.getString("LopID"), // LopID
                        rs.getInt("Tai_KhoanID") // Tai_KhoanID
                );
                lsv.add(sv);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lsv;
    }
    
    //lay sinh vien dang nhap
    public static Sinh_Vien getSV_by_id(String id) {
        Sinh_Vien lsv = null;
        String qr = "select * from Sinh_Vien where ID=?";
        try {
            Connection conn = new DBConnect().getConnection();
            PreparedStatement ps = conn.prepareStatement(qr);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lsv = new Sinh_Vien(
                        rs.getString("ID"), // ID
                        rs.getString("hoTen"), // hoTen
                        rs.getString("gioiTinh"), // gioiTinh
                        rs.getDate("ngaySinh"), // ngaySinh
                        rs.getString("sdt"), // sdt
                        rs.getString("diaChi"), // diaChi
                        rs.getString("email"), // email
                        rs.getString("queQuan"), // queQuan
                        rs.getString("LopID"), // LopID
                        rs.getInt("Tai_KhoanID") // Tai_KhoanID
                );
            }
        } catch (ClassNotFoundException | SQLException  e) {
            // TODO: handle exception
        }
        return lsv;
    }

    //lap danh sach sinh vien theo lop
    public List<Sinh_Vien> getSV_by_LopID(String id) {
        List<Sinh_Vien> lsv = new ArrayList<>();
        String qr = "select * from Sinh_Vien where LopID=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sinh_Vien sv = new Sinh_Vien(
                        rs.getString("ID"), // ID
                        rs.getString("hoTen"), // hoTen
                        rs.getString("gioiTinh"), // gioiTinh
                        rs.getDate("ngaySinh"), // ngaySinh
                        rs.getString("sdt"), // sdt
                        rs.getString("diaChi"), // diaChi
                        rs.getString("email"), // email
                        rs.getString("queQuan"), // queQuan
                        rs.getString("LopID"), // LopID
                        rs.getInt("Tai_KhoanID") // Tai_KhoanID
                );
                lsv.add(sv);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lsv;
    }

    //lay sinh vien dang nhap
    public Sinh_Vien getSV_by_email(String email) {
        Sinh_Vien lsv = null;
        String qr = "select * from Sinh_Vien where email=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                lsv = new Sinh_Vien(
                        rs.getString("ID"), // ID
                        rs.getString("hoTen"), // hoTen
                        rs.getString("gioiTinh"), // gioiTinh
                        rs.getDate("ngaySinh"), // ngaySinh
                        rs.getString("sdt"), // sdt
                        rs.getString("diaChi"), // diaChi
                        rs.getString("email"), // email
                        rs.getString("queQuan"), // queQuan
                        rs.getString("LopID"), // LopID
                        rs.getInt("Tai_KhoanID") // Tai_KhoanID
                );
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return lsv;
    }

    //them sinh vien
    public boolean addSV(Sinh_Vien sv) {
        String sql = "INSERT INTO Sinh_Vien (ID, hoTen, gioiTinh, ngaySinh, sdt, diaChi, email, queQuan, LopID, Tai_KhoanID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        boolean iss = false;
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getId());                // Mã sinh viên
            ps.setString(2, sv.getHoTen());             // Họ tên
            ps.setString(3, sv.getGioiTinh());          // Giới tính
            ps.setDate(4, new java.sql.Date(sv.getNgaySinh().getTime())); // Ngày sinh
            ps.setString(5, sv.getSdt());               // Số điện thoại
            ps.setString(6, sv.getDiaChi());            // Địa chỉ
            ps.setString(7, sv.getEmail());             // Email
            ps.setString(8, sv.getQueQuan());           // Quê quán
            ps.setString(9, sv.getLopID());             // Mã lớp
            ps.setInt(10, sv.getTaiKhoanID());         // Mã tài khoản

            iss = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return iss;
    }

    //cap nhat thong tin
    public boolean updateSinhVien(Sinh_Vien sv) {
        String sql = "UPDATE Sinh_Vien SET hoTen = ?, gioiTinh = ?, ngaySinh = ?, sdt = ?, diaChi = ?, email = ?, queQuan = ?, LopID = ?, Tai_KhoanID = ? WHERE ID = ?";
        boolean rowUpdated = false;

        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getGioiTinh());
            ps.setDate(3, new java.sql.Date(sv.getNgaySinh().getTime())); // assuming getNgaySinh() returns a LocalDate
            ps.setString(4, sv.getSdt());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getEmail());
            ps.setString(7, sv.getQueQuan());
            ps.setString(8, sv.getLopID());
            ps.setInt(9, sv.getTaiKhoanID());
            ps.setString(10, sv.getId());

            // Thực thi câu lệnh UPDATE
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra nếu có dòng bị cập nhật
            rowUpdated = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rowUpdated;  // Trả về true nếu cập nhật thành công, ngược lại là false
    }

    //xoa sinh vien theo id
    public boolean deleteSinhVien_by_ID(String id) {
        String sql = "DELETE FROM Sinh_Vien WHERE ID = ?";
        boolean rowDeleted = false;

        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra nếu có dòng bị xóa
            rowDeleted = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rowDeleted;  // Trả về true nếu xóa thành công, ngược lại là false
    }

}
//te@@
