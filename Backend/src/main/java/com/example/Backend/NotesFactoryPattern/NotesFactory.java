package com.example.Backend.NotesFactoryPattern;

public class NotesFactory {
    public static Notes CreateNote(String type)
    {
        if(type.equals("text"))
        {
            return new Text();
        }
        else if(type.equals("image_text")){
            return new ImageText();
        }
        else{
            return new VoiceText();
        }
    }
}
