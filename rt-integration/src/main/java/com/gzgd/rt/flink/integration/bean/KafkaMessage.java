package com.gzgd.rt.flink.integration.bean;

import java.util.Date;

public class KafkaMessage {
    private String id;    //id

    private String code;  //返回码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
