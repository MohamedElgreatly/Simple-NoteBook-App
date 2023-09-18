package com.example.Backend.RegisterSingleton;

import com.example.Backend.Model.DBConnection;
import com.example.Backend.User;

import java.sql.Statement;

public class SignUp extends DBConnection {
    private static SignUp instance;

    private SignUp(){}
    public static SignUp getInstance(){
        if(instance == null)
        {
            return new SignUp();
        }
        else{
            return instance;
        }
    }

    public String createUser(User user)  {
        try {
            Statement state = DBConnection.connect();

            String query="insert into userinfo values(" +"\'"+ user.getUserName()+"\'"+
                    "," +"\'"+ user.getEmail() +"\'"+ "," +"\'"+ user.getPassword() +"\'"+ "," +"\'"+ user.getStatus() +"\'"+ "," +"\'"+
                    user.getAddress() +"\'"+ "," +"\'"+ user.getCity() +"\'"+ ")";
            state.executeUpdate(query);
            return "Successfully registered";
        }catch(Exception e)
        {
            return "Error";
        }
    }
}
