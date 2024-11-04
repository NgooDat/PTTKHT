package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Giang_Vien;
import java.sql.SQLException;

public class Giang_Vien_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy thông tin giảng viên theo ID
    public Giang_Vien getGiangVien_by_ID(String id) {
        Giang_Vien giangVien = null;
        String qr = "SELECT * FROM Giang_Vien WHERE ID = ?";

        try {
            conn = DBConnect.getConnection();
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
        } catch (SQLException e) {
        }
        return giangVien;
    }

    // Kiểm tra trùng GiangVienId
    public boolean isGiangVienIdExists(String id) {
        boolean exists = false;
        String qr = "SELECT 1 FROM Giang_Vien WHERE ID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, id);  // Đặt giá trị ID vào câu truy vấn
            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;  // GiangVienId tồn tại
            }
        } catch (SQLException e) {
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

    // Hàm cập nhật KhoaIDnew bằng KhoaID cũ cho tất cả giảng viên
    public boolean updateAllKhoaIDnew(String oldKhoaID) {
        String updateQuery = "UPDATE Giang_Vien SET KhoaIDnew = ?";
        boolean isUpdated = false;

        try {
            conn = DBConnect.getConnection();

            // Chuẩn bị câu lệnh cập nhật
            ps = conn.prepareStatement(updateQuery);
            ps.setString(1, oldKhoaID); // Gán KhoaID cũ cho KhoaIDnew

            int rowsAffected = ps.executeUpdate(); // Thực hiện cập nhật

            if (rowsAffected > 0) {
                isUpdated = true; // Cập nhật thành công
            }
        } catch (SQLException e) {
            // In ra lỗi nếu có

        } finally {
            // Đóng kết nối và giải phóng tài nguyên
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
        return isUpdated; // Trả về true nếu cập nhật thành công, ngược lại false
    }

    //lấy toàn bộ giảng viên
    public List<Giang_Vien> getAllGiangVien() {
        List<Giang_Vien> lgv = new ArrayList<>();
        String qr = "select * from Giang_Vien";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lgv;
    }

    //them giang vien
    public boolean addGiangVien(Giang_Vien gv) {
        boolean isSucess = false;
        String qr = "INSERT INTO Giang_Vien (hoTen, gioiTinh, ngaySinh, sdt, email, diaChi, queQuan, Tai_KhoanID, KhoaID,ID) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
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
            isSucess = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // TODO: handle exception

        }
        return isSucess;
    }

    // Hàm cập nhật thông tin giảng viên
    public boolean updateGiangVien(Giang_Vien gv) {
        String qr = "UPDATE Giang_Vien SET hoTen = ?, gioiTinh = ?, ngaySinh = ?, sdt = ?, email = ?, diaChi = ?, queQuan = ?, Tai_KhoanID = ?, KhoaID = ? WHERE ID = ?";
        boolean isSuccess = false;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);

            // Đặt các tham số cho câu truy vấn
            ps.setString(1, gv.getHoTen());             // Đặt giá trị hOTen
            ps.setString(2, gv.getGioiTinh());          // Đặt giá trị gioiTinh
            ps.setDate(3, new java.sql.Date(gv.getNgaySinh().getTime()));  // Đặt giá trị ngaySinh
            ps.setString(4, gv.getSdt());               // Đặt giá trị sdt
            ps.setString(5, gv.getEmail());             // Đặt giá trị email
            ps.setString(6, gv.getDiaChi());            // Đặt giá trị diaChi
            ps.setString(7, gv.getQueQuan());           // Đặt giá trị queQuan
            ps.setInt(8, gv.getTaiKhoanID());          // Đặt giá trị Tai_KhoanID
            ps.setString(9, gv.getKhoaID());            // Đặt giá trị KhoaID
            ps.setString(10, gv.getId());                  // Đặt giá trị ID của giảng viên (để xác định bản ghi nào cần cập nhật)

            // Thực thi câu lệnh và kiểm tra xem có cập nhật thành công không
            isSuccess = ps.executeUpdate() > 0;
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return isSuccess;
    }

    // lấy danh sách giảng viên theo khoa
    public List<Giang_Vien> getGiangVien_by_KhoaID(String khoaID) {
        List<Giang_Vien> giangVienList = new ArrayList<>();
        String sql = "SELECT * FROM Giang_Vien WHERE KhoaID = ?";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, khoaID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Giang_Vien gv = new Giang_Vien();
                gv.setId(rs.getString("ID"));
                gv.setHoTen(rs.getString("hoTen"));
                gv.setGioiTinh(rs.getString("gioiTinh"));
                gv.setNgaySinh(rs.getDate("ngaySinh"));
                gv.setSdt(rs.getString("sdt"));
                gv.setEmail(rs.getString("email"));
                gv.setDiaChi(rs.getString("diaChi"));
                gv.setQueQuan(rs.getString("queQuan"));
                gv.setTaiKhoanID(rs.getInt("Tai_KhoanID"));
                gv.setKhoaID(rs.getString("KhoaID"));
                giangVienList.add(gv);
            }

        } catch (SQLException e) {
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

        return giangVienList;
    }

    //xoa giang vien
    public boolean deleteGiangVien_by_ID(String id) {
        String sql = "DELETE FROM Giang_Vien WHERE ID = ?";
        boolean rowDeleted = false;

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rowsAffected = ps.executeUpdate();
            rowDeleted = rowsAffected > 0;

        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }

        return rowDeleted;  // Trả về true nếu xóa thành công, ngược lại là false
    }

}
//te@@

