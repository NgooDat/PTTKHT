package com.drl.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
	private final String databaseName="teDRL";
	private final String user="sa";
	private final String password="1234";
	public Connection getConnection() throws ClassNotFoundException{
        
        String url = "jdbc:sqlserver://localhost;databaseName="+databaseName+";user="+user+";password="+password+";encrypt=true;trustServerCertificate=true;";
        
        Connection con = null;        
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            
        }
        catch (SQLException e) {
            System.out.println("Khong the ket noi den CSDL \n" );
            System.out.println(e);
            System.out.println("\n-------------------------\n");
        }
        return con;
    }
}


