package com.Hi5.dao;


import com.Hi5.model.User;

public interface UserDao 
{
void userRegistration(User user);
boolean isEmailUnique(String email);
boolean isPhoneNumberUnique(String phonenumber);
User login(User user);
void updateUser(User validUser);
User getUser(String email);
boolean isUpdatedPhonenumberUnique(String phonenumber,String email);
}
