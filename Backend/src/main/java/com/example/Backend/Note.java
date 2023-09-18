package com.example.Backend;

import com.example.Backend.Model.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Note extends DBConnection {
    private String userName;
    private String type;
    private String text;
    public Note(String text,String userName){
        this.userName=userName;
        this.text=text;
    }
    public Note(){}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Note> getNotes(String userName) throws SQLException {
        Statement st =DBConnection.connect();
        System.out.println("select * from usernotes where userName="+"\'"+userName+"\'");
        ResultSet res=st.executeQuery("select * from usernotes where userName="+"\'"+userName+"\'");
        ArrayList<Note> Arr=new ArrayList<>();
        while(res.next()){
            Arr.add(new Note(res.getString(2),res.getString(3)));
        }
        return Arr;
    }
}
