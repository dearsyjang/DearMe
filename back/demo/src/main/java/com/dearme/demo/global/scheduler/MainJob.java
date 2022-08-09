package com.dearme.demo.global.scheduler;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainJob implements Job {

    private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS");

    /**
     * Job interface 구현체
     * Job의 trigger 실행 시 execute() Method는 scheduler의 스레드 중 하나에 의해 호출
     *
     * @param JobExecutionContext
     * 런타임 환경에 대한 정보, 이 환경을 실행한 Scheduler에 대한 핸들, 실행을 트리거한 트리거에 대한 핸들, 작업의 JobDetail 개체 및 기타 몇 가지 항목을 작업 인스턴스에 제공
     */
    @Override
    public void execute(JobExecutionContext ctx) throws JobExecutionException {
        System.out.println("Job Executed [" + new Date(System.currentTimeMillis()) + "]");

        /**
         * JobData에 접근
         */
        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();

        String currentDate = TIMESTAMP_FMT.format(new Date());
        String triggerKey = ctx.getTrigger().getKey().toString(); // group1.trggerName

        String jobSays = dataMap.getString("jobSays"); // Hello World!
        float myFloatValue = dataMap.getFloat("myFloatValue"); // 3.141

        System.out.println(String.format("[%s][%s] %s %s", currentDate, triggerKey, jobSays, myFloatValue));
    }
}