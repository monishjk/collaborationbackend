package com.Hi5.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Hi5.model.User;
@Repository
@Transactional

public class UserDaoImpl implements UserDao
{
	@Autowired
   private SessionFactory sessionFactory;
	
	public void userRegistration(User user) 
	{
	Session session=sessionFactory.getCurrentSession();
	session.save(user);
	}

	public boolean isEmailUnique(String email) 
	{
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		if(user==null)
		  return true;
		else
			return false;
	}

	public boolean isPhoneNumberUnique(String phonenumber)
	{
	   Session session=sessionFactory.getCurrentSession();
	   Query query=session.createQuery("from User where phonenumber=:phnumber");
	   query.setString("phnumber",phonenumber);
	   User user=(User)query.uniqueResult();
	   if(user==null)
		  return true;
	   else
		 return false;
	}

	public User login(User user) 
	{
	  Session session=sessionFactory.getCurrentSession();
	  Query query=session.createQuery("from User where email=:email and password=:passwd");
	  query.setString("email",user.getEmail());
	  query.setString("passwd",user.getPassword());
	  User validuser=(User)query.uniqueResult();
	  return validuser;
	
	}

	public void updateUser(User validUser)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(validUser);
		
	}
	public User getUser(String email) 
	{
	   Session session=sessionFactory.getCurrentSession();
	   User user=(User)session.get(User.class, email);
		return user;
	}

	public boolean isUpdatedPhonenumberUnique(String phonenumber,String email)
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=:email and phonenumber=:phnumber");
		query.setString("email", email);
		query.setString("phnumber",phonenumber);
		User user=(User)query.uniqueResult();
		if(user==null)
			return true;
		else
		    return false;
	}

	

}
