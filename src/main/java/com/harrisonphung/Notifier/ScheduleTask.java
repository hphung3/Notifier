package com.harrisonphung.Notifier;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by harrisonphung on 1/4/19.
 */
@Component
public class ScheduleTask {

//    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void printHello(){
        System.out.println("Hello from schedule");
    }

}
