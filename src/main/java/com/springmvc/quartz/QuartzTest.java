package com.springmvc.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzTest implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("hello quartz");

        throw new JobExecutionException("Testing Exception");

    }
}
