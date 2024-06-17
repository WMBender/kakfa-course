package com.weslei.bender.str_consumer.listener;

import com.weslei.bender.str_consumer.custom.CustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @CustomListener(groupId = "group-0")
    public void listener(String message){
       log.info("Received message {}", message);
    }

    @CustomListener(groupId = "group-0")
    public void log(String message){
        log.info("Received message {}", message);
    }

    @CustomListener(groupId = "group-1")
    public void history(String message){
        log.info("Received message {}", message);
    }
}
