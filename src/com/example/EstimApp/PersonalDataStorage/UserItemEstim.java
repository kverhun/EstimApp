package com.example.EstimApp.PersonalDataStorage;

/**
 * Created by sersajur on 11.12.2015.
 */
public class UserItemEstim {

    public UserItemEstim(){
    }
    public UserItemEstim(String i_login, String i_itemName, int i_estimation){
        login = i_login;
        itemName = i_itemName;
        estimation = i_estimation;
    }

    public String GetLogin(){
        return login;
    }
    public String GetItemName(){
        return itemName;
    }
    public int GetEstim(){
        return estimation;
    }

    private String login;
    private String itemName;
    private int estimation;
}
