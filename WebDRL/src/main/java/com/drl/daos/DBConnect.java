package com.drl.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    private static final String databaseName = "teDRL";
    private static final String user = "sa";
    private static final String password = "123";

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + databaseName + ";user=" + user + ";password=" + password + ";encrypt=true;trustServerCertificate=true;";

        Connection con = null;
        try {
            // Tùy chọn, nếu bạn muốn xác định rõ driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, "Driver không tìm thấy: " + ex.getMessage(), ex);
        } catch (SQLException e) {
            System.out.println("Không thể kết nối đến CSDL:");
            System.out.println(e.getMessage());
            System.out.println("\n-------------------------\n");
        }
        return con;
    }

}
