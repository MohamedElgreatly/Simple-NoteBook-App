package com.example.Backend.NotesFactoryPattern;

import com.example.Backend.Note;

import java.sql.SQLException;

public interface Notes {
    String saveNote(Note note) throws SQLException;
}
