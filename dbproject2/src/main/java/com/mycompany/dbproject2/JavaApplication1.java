package com.mycompany.dbproject2;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JavaApplication1 {

 
    public static void main(String[] args) throws SQLException {
        
      Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres1", "postgres", "student");
        System.out.println("Connection Successful");  
        
         CallableStatement proc = con.prepareCall("select insertman(?, ?, ?)");
        proc.setString(1, "Dominik");
        proc.setString(2, "Kozłowski");
        proc.setInt(3, 21);
         proc.execute();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM man");
        ps.execute();

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String Name = rs.getString("name");
            String surName = rs.getString("surname");
            String Age = rs.getString("age");
            System.out.println(Name+surName+Age);
           
        }
        
        rs.close();
        ps.close();
        con.close();
        
    }
}