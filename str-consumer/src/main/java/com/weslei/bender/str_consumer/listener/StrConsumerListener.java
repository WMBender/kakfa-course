package com.weslei.bender.str_consumer.listener;

import com.weslei.bender.str_consumer.custom.CustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows
    @CustomListener(groupId = "group-0")
    public void listener(String message){
       log.info("Received message {}", message);
       throw new IllegalArgumentException("EXCEPTION!");
    }

    @CustomListener(groupId = "group-0")
    public void log(String message){
        log.info("Received message {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message){
        log.info("Received message {}", message);
    }


}
