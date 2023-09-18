package com.example.Backend.NotesFactoryPattern;

import com.example.Backend.Note;
import com.example.Backend.Model.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class Text extends DBConnection implements Notes {
    @Override
    public String saveNote(Note note) throws SQLException {
        Statement st =  DBConnection.connect();
        st.executeUpdate("insert into usernotes values(null,"+"\'"+note.getText()+"\'"+","+"\'"+note.getUserName()+"\'"+")");
        return "text note saved successfully";
    }
}
