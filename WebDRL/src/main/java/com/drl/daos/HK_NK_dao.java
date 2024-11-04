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
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HK_NK hknk = new HK_NK(rs.getInt("ID"),
                        rs.getString("nienKhoa"),
                        rs.getInt("hocKy"),
                        rs.getInt("xet"));
                dsHK_NK.add(hknk);
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
        return dsHK_NK;
    }

    public HK_NK getHK_NKByHocKyAndNienKhoa(int hocKy, String nienKhoa) {
        HK_NK hkNk = null;
        String query = "SELECT * FROM HK_NK WHERE hocKy = ? AND nienKhoa = ?";
        
        try (Connection con2 = DBConnect.getConnection();
             PreparedStatement stmt = con2.prepareStatement(query)) {
            
            stmt.setInt(1, hocKy);
            stmt.setString(2, nienKhoa);

            try (ResultSet s = stmt.executeQuery()) {
                if (s.next()) {
                    hkNk = new HK_NK();
                    hkNk.setId(s.getInt("id"));
                    hkNk.setHocKy(s.getInt("hocKy"));
                    hkNk.setNienKhoa(s.getString("nienKhoa"));

                    // Thiết lập các thuộc tính khác của HK_NK nếu có
                }
            }
        } catch (SQLException e) {
        }
        
        return hkNk;
    }

    // Lấy một HK_NK có xet = 1
    public HK_NK getHK_NKWithXetEqualOne() {
        HK_NK hknk = null;
        String query = "SELECT * FROM HK_NK WHERE xet = 1";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                hknk = new HK_NK(
                        rs.getInt("ID"),
                        rs.getString("nienKhoa"),
                        rs.getInt("hocKy"),
                        rs.getInt("xet")
                );
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
        return hknk;
    }

    public void updateHK_NK(int id) {
        String updateAllQuery = "UPDATE HK_NK SET xet = 0";
        String updateSpecificQuery = "UPDATE HK_NK SET xet = 1 WHERE ID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnect.getConnection();

            // Cập nhật tất cả HK_NK thành 0
            ps = conn.prepareStatement(updateAllQuery);
            ps.executeUpdate();
            ps.close();

            // Cập nhật HK_NK với id cụ thể thành 1
            ps = conn.prepareStatement(updateSpecificQuery);
            ps.setInt(1, id);
            ps.executeUpdate();

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
    }

    //lay hknk theo id
    public HK_NK getHK_NK_by_ID(int id) {
        HK_NK hknk = null;
        String query = "SELECT * FROM HK_NK WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                hknk = new HK_NK(rs.getInt("ID"),
                        rs.getString("nienKhoa"),
                        rs.getInt("hocKy"),
                        rs.getInt("xet"));
            }
        } catch (SQLException e) {
        }
        return hknk;
    }

    //lay ds hknk theo nien khoa
    public List<HK_NK> getHK_NK_by_NienKhoa(String nienKhoa) {
        List<HK_NK> dsHK_NK = new ArrayList<>();
        String query = "SELECT * FROM HK_NK WHERE nienKhoa = ?";
        try {
            conn = DBConnect.getConnection();
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
        } catch (SQLException e) {
        }
        return dsHK_NK;
    }

    //them hknk
    public boolean addHK_NK(HK_NK hknk) {
        String query = "INSERT INTO HK_NK (nienKhoa, hocKy, xet) VALUES (?, ?, ?)";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, hknk.getNienKhoa());
            ps.setInt(2, hknk.getHocKy());
            ps.setInt(3, hknk.getXet());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    //cap nhat hknk
    public boolean updateHK_NK(HK_NK hknk) {
        String query = "UPDATE HK_NK SET nienKhoa = ?, hocKy = ?, xet = ? WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, hknk.getNienKhoa());
            ps.setInt(2, hknk.getHocKy());
            ps.setInt(3, hknk.getXet());
            ps.setInt(4, hknk.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    //xoa hknk
    public boolean deleteHK_NK(int id) {
        String query = "DELETE FROM HK_NK WHERE ID = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

}
//te@@

