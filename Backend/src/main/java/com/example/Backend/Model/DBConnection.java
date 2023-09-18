package com.example.Backend.Model;

import com.example.Backend.Password;

import java.sql.*;

public class DBConnection extends Password {
    public static Statement connect(){
        String url="jdbc:mysql://localhost:3306/wep_notes";
        String username="root";
        try{
            System.out.println(Password.password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection(url,username,Password.password);
            Statement statement =con.createStatement();
            return statement;
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

//    public static void main(String[] args) throws SQLException {
//        Statement st =DBConnection.connect();
//        String sql="insert into usernotes values(null,'you something tomorrow','khalid')";
//        st.executeUpdate(sql);
//    }
}
