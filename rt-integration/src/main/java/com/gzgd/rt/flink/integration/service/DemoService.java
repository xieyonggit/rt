package com.gzgd.rt.flink.integration.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String print(String item1,String item2) {
        String item = item1 + item2;
        System.out.println(item);
        return item;
    }
}
