package com.springmvc.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class MultipleWorl {

    public static void main(String[] args)throws Exception{

        JobKey jobKeyA = new JobKey("dumpTriggerNameA","groupA");
        JobDetail jobDetailA = JobBuilder.newJob(JobA.class).withIdentity(jobKeyA).build();

        JobKey jobKeyB = new JobKey("dumpTriggerNameB","groupB");
        JobDetail jobDetailB = JobBuilder.newJob(JobB.class).withIdentity(jobKeyB).build();

        JobKey jobKeyC = new JobKey("dumpTriggerNameC","groupC");
        JobDetail jobDetailC = JobBuilder.newJob(JobC.class).withIdentity(jobKeyC).build();


        // 开始编写触发器

        Trigger triggerA = TriggerBuilder.newTrigger()
                .withIdentity("dumpTriggerNameA","groupA")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        Trigger triggerB = TriggerBuilder.newTrigger()
                .withIdentity("dumpTriggerNameB" ,"groupB")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        Trigger triggerC = TriggerBuilder.newTrigger()
                .withIdentity("dumpTriggerNameC" ,"groupC")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();


        Scheduler scheduler =new StdSchedulerFactory().getScheduler();
        // 如果有监听器，这里可以插入监听器，监听任务的运行
        scheduler.start();

        scheduler.scheduleJob(jobDetailA,triggerA);
        scheduler.scheduleJob(jobDetailB,triggerB);
        scheduler.scheduleJob(jobDetailC,triggerC);


    }
}
