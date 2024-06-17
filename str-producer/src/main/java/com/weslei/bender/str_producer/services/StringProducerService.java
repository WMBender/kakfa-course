package com.weslei.bender.str_producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Sending message {}", message);
        kafkaTemplate.send("str-topic", message);
//            .addCallback(
//            success -> {
//                if(success != null){
//                    log.info("Sent message with success: {}", message);
//                    log.info("Partition {}, Offset {}",
//                            success.getRecordMetadata().partition(),
//                            success.getRecordMetadata().offset());
//                }
//
//            },
//            error -> log.error("Erro ao enviar mensagem")
//        );
    }
}
