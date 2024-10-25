package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.drl.models.Tai_Khoan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Tai_Khoan_dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static Tai_Khoan getTaiKhoanLogin(String email, String password) throws ClassNotFoundException, InterruptedException, ExecutionException {
        String query = "SELECT * FROM Tai_Khoan WHERE email=? AND password=?";
        Tai_Khoan taiKhoan = null; // Khởi tạo đối tượng Tai_Khoan là null

        try {
            Connection conn = new DBConnect().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password); // Cân nhắc sử dụng mật khẩu đã băm thay vì mật khẩu thô

            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // Kiểm tra xem có kết quả nào không
                taiKhoan = new Tai_Khoan(); // Tạo một đối tượng Tai_Khoan mới
                taiKhoan.setId(rs.getInt("id")); // Lấy ID từ ResultSet
                taiKhoan.setEmail(rs.getString("email")); // Lấy email từ ResultSet
                taiKhoan.setPassword(rs.getString("password")); // Lấy mật khẩu từ ResultSet (nếu cần)
                taiKhoan.setStatus(rs.getInt("status")); // Lấy status từ ResultSet
                taiKhoan.setRulesID(rs.getInt("rulesID")); // Lấy rulesID từ ResultSet
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ, có thể ghi log nếu cần
            
        } 
        return taiKhoan;
    }

    //lay thong tin tai khoan theo email
    public Tai_Khoan getTaiKhoan_by_email(String email) {
        Tai_Khoan tk = null;
        String qr = "select * from Tai_Khoan where email=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(qr);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                tk = new Tai_Khoan(rs.getInt("ID"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("status"),
                        rs.getInt("RulesID"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
        }
        return tk;
    }
    
    //kiem tra dang nhap
    public boolean checkLogin(String email, String password) {
        String query = "SELECT * FROM Tai_Khoan WHERE email=? AND password=?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();  // Trả về true nếu có kết quả
        } catch (ClassNotFoundException | SQLException e) {
        } 
        return false;
    }
    
    //lay thong tin tat ca tai khoan
    public List<Tai_Khoan> getAllTaiKhoan() {
        List<Tai_Khoan> dsTaiKhoan = new ArrayList<>();
        String query = "SELECT * FROM Tai_Khoan";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tai_Khoan tk = new Tai_Khoan(rs.getInt("ID"),
                                             rs.getString("email"),
                                             rs.getString("password"),
                                             rs.getInt("status"),
                                             rs.getInt("RulesID"));
                dsTaiKhoan.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return dsTaiKhoan;
    }
    
    //them tai khoan
    public boolean addTaiKhoan(Tai_Khoan taiKhoan) {
        String query = "INSERT INTO Tai_Khoan (email, password, status, RulesID) VALUES (?, ?, ?, ?)";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, taiKhoan.getEmail());
            ps.setString(2, taiKhoan.getPassword());
            ps.setInt(3, taiKhoan.getStatus());
            ps.setInt(4, taiKhoan.getRulesID());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    //cap nhat tai khoan
    public boolean updateTaiKhoan(Tai_Khoan taiKhoan) {
        String query = "UPDATE Tai_Khoan SET email = ?, password = ?, status = ?, RulesID = ? WHERE ID = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, taiKhoan.getEmail());
            ps.setString(2, taiKhoan.getPassword());
            ps.setInt(3, taiKhoan.getStatus());
            ps.setInt(4, taiKhoan.getRulesID());
            ps.setInt(5, taiKhoan.getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    //xoa tai khoan
    public boolean deleteTaiKhoan(int id) {
        String query = "DELETE FROM Tai_Khoan WHERE ID = ?";
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
