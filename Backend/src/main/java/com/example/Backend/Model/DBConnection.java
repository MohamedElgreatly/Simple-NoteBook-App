package com.example.Backend.Model;

import com.example.Backend.Note;
import com.example.Backend.Password;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;

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

//    public static void main(String[] args) throws SQLException, JsonProcessingException {
//        Statement st =DBConnection.connect();
//        String sql="select * from usernotes where userName='Ahmed'";
//        System.out.println(st.executeQuery(sql));
//        ResultSet res= st.executeQuery(sql);
//        ArrayList<Note> Arr=new ArrayList<>();
//        while(res.next()){
//            Arr.add(new Note(res.getString(2),res.getString(3)));
//        }
//        System.out.println(Arr.get(0).getText());
//
//    }


}
