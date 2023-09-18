package com.example.Backend;

import com.example.Backend.Model.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Note extends DBConnection {
    private String userName;
    private String type;
    private String text;

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
    public ResultSet getNotes(String userName) throws SQLException {
        Statement st =DBConnection.connect();
        return st.executeQuery("select * from usernotes where userName="+userName);
    }
}
