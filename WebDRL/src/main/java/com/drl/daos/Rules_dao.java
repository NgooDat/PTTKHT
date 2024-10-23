package com.drl.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.drl.models.Rules;

public class Rules_dao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<Rules> getAllRule() {
	    List<Rules> dsRules = new ArrayList<>();
	    String query = "SELECT * FROM Rules";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Rules rule = new Rules(rs.getInt("ID"),
	                                   rs.getString("name"));
	            dsRules.add(rule);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
	    }
	    return dsRules;
	}

}
