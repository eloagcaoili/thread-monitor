package com.aagcaoili.threadmonitor;

import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public interface IThreadPoolMonitorService extends Runnable{

    void monitorThreadPool();
    ThreadPoolTaskExecutor getThreadPoolTaskExecutor();
    void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor executor);

}
