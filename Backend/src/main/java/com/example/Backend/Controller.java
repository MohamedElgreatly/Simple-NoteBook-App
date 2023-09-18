package com.example.Backend;

import com.example.Backend.NotesFactoryPattern.Notes;
import com.example.Backend.NotesFactoryPattern.NotesFactory;
import com.example.Backend.RegisterSingleton.SignIn;
import com.example.Backend.RegisterSingleton.SignUp;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("NoteBook")
public class Controller {

    @PostMapping("/signUp")
    public String CreateUser(@RequestBody User user)
    {
      SignUp instance =SignUp.getInstance();
      return instance.createUser(user);
    }
    @PostMapping("/signIn")
    public String CeckUser(@RequestBody User user)
    {
        SignIn instance =SignIn.getInstance();
        return instance.checkRegister(user);
    }

    @PostMapping("/AddNote")
    public String AddNote(@RequestBody Note note) throws SQLException {
        Notes obj =NotesFactory.CreateNote(note.getType());
        return obj.saveNote(note);

    }
    @GetMapping("/getNotes")
    public ArrayList<Note> getNotes(@RequestParam String userName) throws SQLException {
        Note obj =new Note();
        System.out.println(obj.getNotes(userName));
        return obj.getNotes(userName);
    }
}
