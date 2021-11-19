package com.doc.juicy.model;

/**
 * Created by Techpass Master on 01-Jul-20.
 * www.techpassmaster.com
 */

public class UserData {
    public String Fullname,Username,EmailId,Gender;

    public UserData(){
    }
    public UserData(String fullname, String username, String emailId, String gender) {
        Fullname = fullname;
        Username = username;
        EmailId = emailId;
        Gender = gender;
    }
}