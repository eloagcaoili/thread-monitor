package com.aagcaoili.threadmonitor;

import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Slf4j
public class ThreadPoolMonitorService implements IThreadPoolMonitorService{



    private ThreadPoolTaskExecutor taskExecutor;



    @Override
    public void monitorThreadPool() {
        log.info("================= Thread Pool Stats ================");
        log.info("Current pool size: {} ", taskExecutor.getCorePoolSize());
        log.info("Current max pool size: {}", taskExecutor.getMaxPoolSize());
        log.info("Active tasks: {}", taskExecutor.getThreadPoolExecutor().getActiveCount());
        log.info("Competed Task count: {}", taskExecutor.getThreadPoolExecutor().getCompletedTaskCount());
        log.info("Terminated: {}", taskExecutor.getThreadPoolExecutor().isTerminated());
        log.info("====================================================");
//        log.info("Total tasks: {}" , taskExecutor.);


    }

    @Override
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        return taskExecutor;
    }

    @Override
    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor executor){
        this.taskExecutor = executor;
    }

    public void run(){
        try{
            while (true){
                monitorThreadPool();
                try{
                Thread.sleep(3000);}
                catch (InterruptedException ie){
                    log.error(ie.toString());
                }
            }
        }
        catch (Exception ie){
            log.error(ie.toString());
        }
    }



}
