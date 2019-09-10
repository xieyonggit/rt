package com.gzgd.rt.flink.integration.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gzgd.rt.flink.integration.bean.Item;
import com.gzgd.rt.flink.integration.bean.ItemWithWikiInfo;
import com.gzgd.rt.flink.integration.bean.ItemWithoutWikiInfo;
import com.gzgd.rt.flink.integration.bean.WikiInfo;
import com.gzgd.rt.flink.integration.dao.HbaseDao;
import com.gzgd.rt.flink.integration.dao.KafkaReceiver;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

import java.util.Map;

@Service
public class IntegrationServiceImpl implements IntegrationService {
    @Autowired
    private HbaseDao hbaseDao;
    @Autowired
    private KafkaReceiver kafkaReceiver;

    public static final Logger logger = LoggerFactory.getLogger(IntegrationServiceImpl.class);

    public Item typeDistinguish(Item item) {
        Item obj = new Item();

        // 如果type类型是video那么extend解析为wikiInfo对象
        if (item.getType().equals("video")) {
            String itemString = JSONObject.toJSONString(item);
            ItemWithWikiInfo itemObject = JSON.parseObject(itemString, ItemWithWikiInfo.class);
            WikiInfo extendObject = (WikiInfo) itemObject.getExtend();
            try {
                Validate.notNull(extendObject.getCover());
                Validate.notNull(extendObject.getModel());
            } catch (Exception e) {
                logger.error("extend数据缺失");
            }
            logger.info("取值：{}", extendObject.getCover());
            obj = itemObject;
        }
        //如果type类型是那么extend解析为Map
        else if (item.getType().equals("normal")) {
            String itemString = JSONObject.toJSONString(item);
            ItemWithoutWikiInfo itemObject = JSON.parseObject(itemString, ItemWithoutWikiInfo.class);
            Map a = itemObject.getExtend();
            logger.info("extend的值：{}", itemObject.getExtend().get("cover"));
            obj = itemObject;
        } else {
            logger.error("没有这个type类型");
        }

        return obj;
    }


  /**
     * @param item
     * tablename这里写死了，需要修改
     */

  public void saveMaterial(Item item){
        Class clazz=item.getClass();
        Field[] fs=clazz.getDeclaredFields();
        for(Field field : fs) {
            String fieldName = field.getName();
            String getMethod = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1,fieldName.length());
            try{
            hbaseDao.saveMaterial("item_backups", item.getBid()+"-"+ item.getItemId(),"cf",fieldName, clazz.getMethod(getMethod).invoke(item).toString().getBytes());
            }catch (Exception e){
            }
        }

    }


    public void getMaterial(ItemWithWikiInfo itemWithWikiInfo){
        hbaseDao.saveMaterial("item_backups", itemWithWikiInfo.getBid().toString()+"-"+ itemWithWikiInfo.getItemId(),"cf","itemId", itemWithWikiInfo.getItemId().getBytes());
    }

}
