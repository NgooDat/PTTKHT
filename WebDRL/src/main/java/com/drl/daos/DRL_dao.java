package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DRL_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //cap nhat diem ren luyen
    public boolean updateDiem(int id, String capDG) {
        boolean isSucess = false;
        String loaiD = "";
        if (capDG.equals("SV")) {
            loaiD = "diemSV";
        } else if (capDG.equals("CS")) {
            loaiD = "diemCS";
        } else {
            loaiD = "diemCV";
        }
        String qr = "UPDATE DRL "
                + "SET " + loaiD + " = (SELECT SUM (diem) FROM Diem_CT WHERE DRLID = ? AND capDG = ?)"
                + " WHERE ID = ?;";
        //System.out.println(qr);
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            ps.setInt(1, id);
            ps.setString(2, capDG);
            ps.setInt(3, id);
            isSucess = ps.executeUpdate() > 0;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return isSucess;
    }
}
