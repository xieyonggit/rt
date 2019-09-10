package com.gzgd.rt.flink.integration.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

import java.io.IOException;

/**
 * @author: john
 * @date: 2019/6/28
 */
@Configuration
@EnableConfigurationProperties(HBaseProperties.class)
public class HBaseConfig {
    @Autowired
    private HBaseProperties hBaseProperties;

    @Bean
    public org.apache.hadoop.conf.Configuration configuration(){
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", this.hBaseProperties.getZkQuorum());
        configuration.set("zookeeper.znode.parent", this.hBaseProperties.getZkBasePath());
        return configuration;
    }


    @Bean
    public Connection connection(org.apache.hadoop.conf.Configuration configuration) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;

    }

    @Bean
    public HbaseTemplate hbaseTemplate(org.apache.hadoop.conf.Configuration configuration) {
        HbaseTemplate hbaseTemplate = new HbaseTemplate(configuration);
        hbaseTemplate.setAutoFlush(false);
        return hbaseTemplate;
    }



}
