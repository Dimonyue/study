package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yxg
 */
@RestController
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void send() throws InterruptedException {
        for(int i=0; i< 20;i++){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String value ="次数: " + i + "time: "+simpleDateFormat.format(new Date());
            kafkaTemplate.send("topic_01",value);
            Thread.sleep(1000);
        }

    }
}
