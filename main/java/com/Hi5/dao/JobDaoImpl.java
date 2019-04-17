package com.Hi5.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.Hi5.model.Job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao
{
   @Autowired
  private SessionFactory sessionFactory;
   public void addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);	
		}
	
	public List<Job> getAllJobs() {
		 Session session=sessionFactory.getCurrentSession();
		    Query query=session.createQuery("from Job");
		    List<Job> jobs=query.list();
		   return jobs;
	}

}
