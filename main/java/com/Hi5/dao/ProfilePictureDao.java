package com.Hi5.dao;


import com.Hi5.model.ProfilePicture;

public interface ProfilePictureDao 
{
	void saveOrUpdateProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getProfilePicture(String email);
}
