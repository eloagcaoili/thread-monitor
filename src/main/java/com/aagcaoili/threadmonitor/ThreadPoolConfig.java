package com.aagcaoili.threadmonitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {




    @Value("${corePoolSize}")
    private int corePoolSize;

    @Value("${maxPoolSize}")
    private int maxPoolSize;

    @Value("${maxQueueSize}")
    private int maxQueueSize;



    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("myExecutor");
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(maxQueueSize);
        return  executor;
    }

}
