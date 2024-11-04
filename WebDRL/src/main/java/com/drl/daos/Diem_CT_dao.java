package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Diem_CT;
import java.sql.SQLException;

public class Diem_CT_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lay danh sach diem cua sv theo cấp đánh giá và drlID
    public List<Diem_CT> getDiem_CT_by_capDG_DRLID(String cap, int id) {
        List<Diem_CT> lst = new ArrayList<>();
        String qr = "select * from Diem_CT where capDG=? AND DRLID=?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, cap);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Diem_CT d = new Diem_CT(
                        rs.getInt("ID"),
                        rs.getInt("diem"),
                        rs.getString("capDG"),
                        rs.getInt("DRLID"),
                        rs.getInt("CT_TCID"));
                lst.add(d);
            }
        } catch (SQLException e) {
            // TODO: handle exception

        }
        return lst;
    }

    //them điểm chi tiết
    public boolean addDiem_CT(Diem_CT d) {
        boolean result = false;
        String sql = "INSERT INTO Diem_CT (diem, DRLID, CT_TCID, capDG) VALUES (?, ?, ?, ?)";

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getDiem());        // Điểm của tiêu chí cụ thể
            ps.setInt(2, d.getDRLID());       // ID của DRL
            ps.setInt(3, d.getCT_TCID());     // ID của CT_TC
            ps.setString(4, d.getCapDG());    // Cấp đánh giá (Sinh viên, Cán sự, Cố vấn)

            // Thực thi câu lệnh
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }

        return result;
    }

    //sửa điểm chi tiết
    public boolean updateDiem_CT(Diem_CT d) {
        String query = "UPDATE Diem_CT SET diem = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection(); // Mở kết nối
            ps = conn.prepareStatement(query); // Chuẩn bị câu lệnh SQL
            ps.setInt(1, d.getDiem()); // Gán giá trị điểm từ đối tượng Diem_CT
            ps.setInt(2, d.getId());   // Gán giá trị ID từ đối tượng Diem_CT
            int rowsUpdated = ps.executeUpdate(); // Thực thi câu lệnh UPDATE

            return rowsUpdated > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) { // Xử lý ngoại lệ
            // Xử lý ngoại lệ
            return false; // Trả về false nếu có lỗi
        } finally {
            try {
                if (ps != null) {
                    ps.close(); // Đóng PreparedStatement
                }
                if (conn != null) {
                    conn.close(); // Đóng kết nối
                }
            } catch (SQLException e) {
            }
        }

    }

    //xoa diem chi tiet
    public boolean deleteDiem_CT(int id) {
        String query = "DELETE FROM Diem_CT WHERE ID = ?";
        try {
            conn = DBConnect.getConnection(); // Mở kết nối
            ps = conn.prepareStatement(query); // Chuẩn bị câu lệnh SQL
            ps.setInt(1, id); // Gán giá trị ID vào câu lệnh SQL
            int rowsDeleted = ps.executeUpdate(); // Thực thi câu lệnh DELETE

            return rowsDeleted > 0; // Trả về true nếu xóa thành công
        } catch (SQLException e) { // Xử lý ngoại lệ
            // Xử lý ngoại lệ
            return false; // Trả về false nếu có lỗi
        } finally {
            try {
                if (ps != null) {
                    ps.close(); // Đóng PreparedStatement
                }
                if (conn != null) {
                    conn.close(); // Đóng kết nối
                }
            } catch (SQLException e) {
            }
        }
    }
}
//te@@
