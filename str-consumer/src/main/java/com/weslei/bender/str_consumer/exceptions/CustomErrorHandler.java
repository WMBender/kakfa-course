package com.weslei.bender.str_consumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomErrorHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
       log.info("EXCEPTION HANDLER ::: Caught an error !");
       log.info("Payload ::: {}", message.getPayload());
       log.info("Headers ::: {}", message.getHeaders());
       log.info(exception.getMessage());
        return null;
    }

}
