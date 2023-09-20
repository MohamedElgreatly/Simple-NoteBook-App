package com.example.Backend.NotesFactoryPattern;

        import com.example.Backend.Model.DBConnection;
        import com.example.Backend.Note;

        import java.sql.SQLException;
        import java.sql.Statement;

public class VoiceText implements Notes{

    @Override
    public String saveNote(Note note) throws SQLException {
        Statement st =  DBConnection.connect();
        st.executeUpdate("insert into usernotes values(null,"+"\'"+note.getText()+"\'"+","+"\'"+note.getUserName()+"\'"+")");
        return "Voice note saved successfully";
    }
}
