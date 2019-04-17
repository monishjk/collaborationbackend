package com.Hi5.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.Hi5.model.Friend;

import com.Hi5.model.User;
@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
@Autowired
private SessionFactory sessionFactory;
	public List<User> getAllSuggestedUsers(String email) 
	{
		Session session=sessionFactory.getCurrentSession();

		String queryString="select * from user_monish where email in "  //S
				+ "(select email from user_monish where email!=:e1 "  //A
				+ "    minus "
				+ "  (select toId_email from Friends where fromId_email=:e2 "  //B
				+ "       union "
				+ "   select fromId_email from Friends where toId_email=:e3"
				+ "  )" //C
				+ ")";
		SQLQuery sqlQuery=session.createSQLQuery(queryString);
		sqlQuery.setString("e1", email);
		sqlQuery.setString("e2", email);
		sqlQuery.setString("e3", email);
		sqlQuery.addEntity(User.class);
		//to convert it into an object of type USER
        List<User> suggestedUsers=sqlQuery.list();
        return suggestedUsers;
	}
		//return sqlQuery.list();


	public void addFriend(Friend friend) 
	{
		System.out.println("Friend Id is "+friend.getFriendId());
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
    }

	public List<Friend> getPendingRequests(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId.email=:email and status=:status");
		query.setString("email", email);
		query.setCharacter("status", 'P');
		List<Friend> pendingRequests=query.list();
		return pendingRequests;
	}
	public void acceptRequest(Friend pendingRequest)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(pendingRequest);
	}
	public void deleteRequest(Friend pendingRequest) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.delete(pendingRequest);
	}
	public List<User> listOfFriends(String email) 
	{
		Session session=sessionFactory.getCurrentSession();
		
		Query query1=session.createQuery("select f.fromId from Friend f where f.toId.email=:e1 and f.status='A'");
		query1.setString("e1", email);
		List<User> list1=query1.list();
		
		Query query2=session.createQuery("select f.toId from Friend f where f.fromId.email=:e2 and f.status='A'");
		query2.setString("e2", email);
		List<User> list2=query2.list();
		
		list1.addAll(list2);
		
		return list1;
	}


}
