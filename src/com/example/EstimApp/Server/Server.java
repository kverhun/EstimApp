package com.example.EstimApp.Server;

/**
 * Created by Kostya on 09.12.2015.
 */
public class Server {

    public boolean checkLoginInfo(String username, String password){
        return checkUsername(username) && checkPassword(password);
    }

    private boolean checkUsername(String username){
        return username.equals("admin");
    }

    private boolean checkPassword(String password){
        return password.equals("admin");
    }


}
