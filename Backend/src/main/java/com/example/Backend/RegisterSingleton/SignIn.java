package com.example.Backend.RegisterSingleton;

import com.example.Backend.Model.DBConnection;
import com.example.Backend.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class SignIn {

    private static SignIn instance;
    private SignIn(){}

    public static SignIn getInstance(){
        if(instance == null)
        {
            return new SignIn();
        }
        else{
            return instance;
        }
    }

    public String checkRegister(User user){
        try {
            Statement state = DBConnection.connect();
            ResultSet res=state.executeQuery("select userName from userinfo where userName=" +"\'"+ user.getUserName()+"\'");
            res.next();
            return res.getString(1);
        }catch (Exception e)
        {
            return "Error ";
        }
    }
}
