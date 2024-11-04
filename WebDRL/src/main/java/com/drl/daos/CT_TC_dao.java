package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.CT_TC;
import java.sql.SQLException;

public class CT_TC_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lay ds chi tiet tieu chi theo tieuChiID
    public List<CT_TC> getCT_TC_by_tieuChiID(int id) {
        List<CT_TC> lst = new ArrayList<>();
        String qr = "select * from CT_TC where Tieu_ChiID =?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(qr);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CT_TC ct = new CT_TC(rs.getInt("ID"),
                        rs.getString("noiDung"),
                        rs.getInt("diemTD"),
                        rs.getInt("Tieu_ChiID"));
                lst.add(ct);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return lst;
    }
    //lay thong tin CT_TC theo id

    public CT_TC getCT_TC_by_ID(int id) {
        String sql = "SELECT * FROM CT_TC WHERE ID = ?";
        CT_TC ct_tc = null;
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);  // 
            rs = ps.executeQuery();

            if (rs.next()) {
                ct_tc = new CT_TC();
                ct_tc.setId(rs.getInt("ID"));
                ct_tc.setNoiDung(rs.getString("noiDung"));
                ct_tc.setDiemTD(rs.getInt("diemTD"));
                ct_tc.setTieuChiID(rs.getInt("Tieu_ChiID"));
            }
        } catch (SQLException e) {
        }
        return ct_tc;
    }

    // them ct_tc
    public boolean addCT_TC(CT_TC ct_tc) {
        String sql = "INSERT INTO CT_TC (noiDung, diemTD, Tieu_ChiID) VALUES (?, ?, ?)";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ct_tc.getNoiDung());
            ps.setInt(2, ct_tc.getDiemTD());
            ps.setInt(3, ct_tc.getTieuChiID());
            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                return true;  // Thêm thành công
            }
        } catch (SQLException e) {
        }
        return false;  // Thêm thất bại
    }

    //cap nhat ct_tc
    public boolean updateCT_TC(CT_TC ct_tc) {
        String sql = "UPDATE CT_TC SET noiDung = ?, diemTD = ?, Tieu_ChiID = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ct_tc.getNoiDung());
            ps.setInt(2, ct_tc.getDiemTD());
            ps.setInt(3, ct_tc.getTieuChiID());
            ps.setInt(4, ct_tc.getId());
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                return true;  // Cập nhật thành công
            }
        } catch (SQLException e) {
        }
        return false;  // Cập nhật thất bại
    }

    //xoa ct_tc
    public boolean deleteCT_TC(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM CT_TC WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                return true;  // Xóa thành công
            }
        } catch (SQLException e) {
        }
        return false;  // Xóa thất bại
    }
}
//te@@
