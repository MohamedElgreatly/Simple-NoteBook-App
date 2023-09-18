package com.example.Backend.NotesFactoryPattern;

public class NotesFactory {
    public static Notes CreateNote(String type)
    {
        if(type.equals("text"))
        {
            return new Text();
        }
        else if(type.equals("image")){
            return new Image();
        }
        else{
            return new Voice();
        }
    }
}
