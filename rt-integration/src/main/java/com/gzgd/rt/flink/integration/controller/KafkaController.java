package com.gzgd.rt.flink.integration.controller;

import com.gzgd.rt.flink.integration.bean.KafkaMessage;
import com.gzgd.rt.flink.integration.dao.KafkaProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin2.message.Message;

import javax.validation.Valid;

@RestController
public class KafkaController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaProvider kafkaProvider;

    @PostMapping(value = "kafka/send")
    public void sendKafka(@Valid  @RequestBody KafkaMessage message) {
        try {
            logger.info("kafka的消息={}", message);
            kafkaProvider.send(message);
            logger.info("发送kafka成功.");

        } catch (Exception e) {

            logger.error("发送kafka失败", e);

        }
    }
}