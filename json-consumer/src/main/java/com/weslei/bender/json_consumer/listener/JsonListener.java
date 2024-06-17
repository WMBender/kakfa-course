package com.weslei.bender.json_consumer.listener;

import com.weslei.bender.json_consumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Received payment {}", payment.toString());
        log.info("Validation there are no frauds ...");
        Thread.sleep(2000);
        log.info("Payment approved");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(){
        Thread.sleep(3000);
        log.info("Generating PDF ...");
        Thread.sleep(1000);
        log.info("PDF generated");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(){
        Thread.sleep(5000);
        log.info("Sending confirmation e-mail ...");
    }
}
