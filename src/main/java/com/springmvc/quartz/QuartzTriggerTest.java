package com.springmvc.quartz;

import com.springmvc.quartz.HellowWorldListener;
import com.springmvc.quartz.QuartzTest;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class QuartzTriggerTest {

    public static void main(String[] args)throws Exception{
        // 因为有两种触发器，所以接下来的我们把两种都是试一下

        JobKey jobKey = new JobKey("dumpTriggerName","group1");

        // 这里我们需要指定Job
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class).withIdentity(jobKey).build();

        // 首先是 SimpleTrigger


//        Trigger trigger = TriggerBuilder.newTrigger()
//
//                .withIdentity("dumpTriggerName","group1")           // 指定 trigger 的信息
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
//                .build();
//

        // 接下来我们再试一下 Crontab 形式的

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("dumpTriggerName","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();



        // 接下来开始写一个 创建一个 Scheduler 将 作业和触发器绑定到一起

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();   // 这里会抛出一个异常

        scheduler.getListenerManager().addJobListener(new HellowWorldListener(), KeyMatcher.keyEquals(jobKey));
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);

    }
}
