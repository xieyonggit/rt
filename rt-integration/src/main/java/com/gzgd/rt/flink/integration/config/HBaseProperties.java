package com.gzgd.rt.flink.integration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: john
 * @date: 2019/6/28
 */
@ConfigurationProperties(prefix = "spring.data.hbase")
public class HBaseProperties {

    private String zkQuorum;

    private String rootDir;

    private String zkBasePath;

    public String getZkQuorum() {
        return zkQuorum;
    }

    public void setZkQuorum(String zkQuorum) {
        this.zkQuorum = zkQuorum;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getZkBasePath() {
        return zkBasePath;
    }

    public void setZkBasePath(String zkBasePath) {
        this.zkBasePath = zkBasePath;
    }
}
