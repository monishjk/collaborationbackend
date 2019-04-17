package com.Hi5.dao;

import java.util.List;


import com.Hi5.model.Friend;

import com.Hi5.model.User;

public interface FriendDao 
{
	List<User> getAllSuggestedUsers(String email);
	void addFriend(Friend friend);
	List<Friend> getPendingRequests(String email);
	void acceptRequest(Friend friend);
	void deleteRequest(Friend friend);
	List<User> listOfFriends(String email);
}
