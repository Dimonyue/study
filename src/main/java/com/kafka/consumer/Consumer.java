package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yxg
 */
@Slf4j
@Component
public class Consumer {

//    @KafkaListener(topics = "topic_01", groupId = "consumer_01")
//    public void listen(ConsumerRecord<String, String> record){
//        log.info("消费： [{}]",record.value());
//    }
}
