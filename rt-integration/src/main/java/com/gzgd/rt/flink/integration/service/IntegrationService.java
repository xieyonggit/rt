package com.gzgd.rt.flink.integration.service;

import com.gzgd.rt.flink.integration.bean.Item;

public interface IntegrationService {
    public Item typeDistinguish(Item item);
    public void saveMaterial(Item item);

}
