package com.gzgd.rt.flink.integration.controller;

import com.gzgd.rt.flink.integration.bean.Item;
import com.gzgd.rt.flink.integration.dao.HbaseDao;
import com.gzgd.rt.flink.integration.dao.KafkaProvider;
import com.gzgd.rt.flink.integration.service.IntegrationService;
import com.gzgd.rt.flink.integration.service.IntegrationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class IntegrationController {
    @Autowired
    private IntegrationService integrationService;
    @Autowired
    private HbaseDao hbaseDao;

    @Autowired
    private KafkaProvider kafkaProvider;

    public static final Logger logger = LoggerFactory.getLogger(IntegrationServiceImpl.class);

    @PostMapping("v1/item")
    public void getItem(@Valid @RequestBody Item item) {
//        if (itemWithWikiInfo.getType().equals("video")){
//            String s=JSONObject.toJSONString(itemWithWikiInfo.getExtend());
//            @Valid WikiInfo wikiInfo = JSON.parseObject(s, WikiInfo.class);
//            logger.info("wikiInfo.getCover()： {}",wikiInfo.getCover());
//        }
        Item itemAfterDistinguish=integrationService.typeDistinguish(item);
        integrationService.saveMaterial(itemAfterDistinguish);

        try {
            logger.info("kafka的消息={}",item);
            kafkaProvider.send(item);
            logger.info("发送kafka成功.");

        } catch (Exception e) {

            logger.error("发送kafka失败", e);

        }
    }


    @RequestMapping("saveMaterialTest")
    public void save(){

        hbaseDao.saveMaterial("item_backups","001","cf","itemTitle","001".getBytes());
    }

    @RequestMapping("getMaterialTest")
    public String getMaterial(){
        return hbaseDao.getMaterial();
    }

    }