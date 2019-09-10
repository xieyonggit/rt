package com.gzgd.rt.flink.integration.dao;

import com.gzgd.rt.flink.integration.service.IntegrationServiceImpl;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HbaseDao {
    public static final Logger logger = LoggerFactory.getLogger(IntegrationServiceImpl.class);

    @Autowired
    private HbaseTemplate hbaseTemplate;

    public void saveMaterial(String tableName,String rowname,String familyName,String qualifier,byte[] value) {

    hbaseTemplate.put(tableName,rowname,familyName,qualifier,value);

    logger.info("插入数据成功,{}:{}",rowname,qualifier);
    }


    public String getMaterial(){
        String Material=hbaseTemplate.get("item_backups","[sd, sdfa]-abc", (result, rowNum) -> {
            String a= Bytes.toString(result.getValue("cf".getBytes(), "itemId".getBytes()));
            System.out.println("material:"+a);
            return a;
        });
        return Material;
    }
}
