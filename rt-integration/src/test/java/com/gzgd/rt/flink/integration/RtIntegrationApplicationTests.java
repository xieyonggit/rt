package com.gzgd.rt.flink.integration;

import com.gzgd.rt.flink.integration.dao.HbaseDao;
import com.gzgd.rt.flink.integration.service.DemoService;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RtIntegrationApplicationTests {
    @Autowired
    HbaseDao hbaseDao;



}
