package com.Hi5.dao;

import java.util.List;


import com.Hi5.model.Job;

public interface JobDao
{
void addJob(Job job);


List<Job> getAllJobs();


}
