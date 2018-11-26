package com.aagcaoili.threadmonitor;

import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
@SpringBootApplication
@EnableAsync
public class ThreadMonitorApplication {

	public static void main(String[] args) throws  InterruptedException{
		SpringApplication.run(ThreadMonitorApplication.class, args);
        ApplicationContext app = SpringApplication.run(ThreadMonitorApplication.class, args);//init the context
        ThreadPoolConfig threadPoolConfig = app.getBean(ThreadPoolConfig.class);//get the bean by type


       /* ThreadPoolExecutor executor = new ThreadPoolExecutor();
        //executor.setThreadNamePrefix("myExecutor");
        executor.setCorePoolSize(4);
        executor.setMaximumPoolSize(8);*/

//        executor.setMaxPoolSize(8);
//        executor.setQueueCapacity(20);
        IThreadPoolMonitorService threadPoolMonitorService = new ThreadPoolMonitorService();
        threadPoolMonitorService.setThreadPoolTaskExecutor(threadPoolConfig.threadPoolTaskExecutor());

		Thread monitor = new Thread(threadPoolMonitorService);
		monitor.start();

		//log.info("thread prefix {}", taskExecutor.getThreadNamePrefix());

		for(int i=0;i<100;i++){
            threadPoolConfig.threadPoolTaskExecutor().execute(new Task (" " + i));
        }


	}

    /*@Bean
    public static ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        return executor;
    }*/
}
