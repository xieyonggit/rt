package com.gzgd.rt.flink.integration.dao;

import com.alibaba.fastjson.JSON;
import com.gzgd.rt.flink.integration.bean.Item;
import com.gzgd.rt.flink.integration.bean.KafkaMessage;
import com.gzgd.rt.flink.integration.bean.TopicConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class KafkaReceiver<T>{
//
//    private static Logger log = LoggerFactory.getLogger(KafkaReceiver.class);
//
//    //发送消息方法
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    @KafkaListener(topics = {TopicConst.EXECUTOR_TOPIC})
//    public void listen(String message) {
//        log.info("------------------接收消息 message =" + message);
//        Item msg = JSON.parseObject(message, Item.class);
//        log.info("MessageConsumer: onMessage: message is: [" + msg + "]");
//        log.info("------------------ message =" + message);
//    }


}
