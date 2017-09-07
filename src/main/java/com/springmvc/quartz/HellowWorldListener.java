package com.springmvc.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class HellowWorldListener implements JobListener{

    public String getName() {
        return "HelloWorld jobListener";
    }


    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {

        String name = jobExecutionContext.getJobDetail().getKey().toString();
        System.out.println("jobToBeExecuted");
        System.out.println("Job:"+name+" is going to start");
    }

    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("jobExecutionVetoed");
    }

    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String name = jobExecutionContext.getJobDetail().getKey().toString();
        System.out.println("jobWasExecuted");
        System.out.println("Job:"+name+" is finished");

        // 如果 job 在运行过程中出现异常，这里可以获取异常信息

        if(!e.getMessage().equals("")){
            System.out.println("Exception throw by:"+name
                    +"Exception: "+e.getMessage());
        }

    }
}
