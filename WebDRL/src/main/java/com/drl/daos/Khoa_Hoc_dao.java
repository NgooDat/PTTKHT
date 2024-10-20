package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
