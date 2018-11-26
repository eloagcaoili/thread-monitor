package com.aagcaoili.threadmonitor;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task implements Runnable {

    private String taskName;


    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void run() {

        try {
            log.info("Task {} started.", taskName);
            Thread.sleep(5000);
            log.info("Task {} completed.", taskName);

        } catch (Exception ie) {
            log.error(ie.toString());
        }
    }

}

