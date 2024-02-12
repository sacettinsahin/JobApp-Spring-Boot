package com.example.jobapp.Service;

import com.example.jobapp.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updatedJobById(Long id, Job updatedJob);
}
