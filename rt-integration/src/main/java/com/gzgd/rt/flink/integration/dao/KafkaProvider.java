package com.gzgd.rt.flink.integration.dao;

import com.alibaba.fastjson.JSON;
import com.gzgd.rt.flink.integration.bean.TopicConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Repository
public class KafkaProvider<T> {

    private static Logger log = LoggerFactory.getLogger(KafkaProvider.class);

    @Autowired
    private KafkaTemplate<String, Object>  kafkaTemplate ;

    //发送消息方法
    public void send(T obj) {
        String jsonObj = JSON.toJSONString(obj);
        log.info("------------ message = {}", jsonObj);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TopicConst.EXECUTOR_TOPIC, jsonObj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("Produce: The message failed to be sent:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //TODO 业务处理
                log.info("Produce: The message was sent successfully:");
                log.info("Produce: _+_+_+_+_+_+_+ result: " + stringObjectSendResult.toString());
            }
        });
    }
}
