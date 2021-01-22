package com.github.study.misc;

import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * CreatedDate: 2020/7/11
 * Author: songjialin
 */
public class NacosTest {
    public static void main(String[] args) throws Exception {
        String serverAddr = "nacos-dev.50lion.com:80";
        String dataId = "test";
        String group = "DEFAULT_GROUP";
        NamingService naming = NamingFactory.createNamingService(serverAddr);
        List<Instance> test = naming.getAllInstances("test");
        ConfigService configService = ConfigFactory.createConfigService(serverAddr);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(test);
        System.out.println(content);
        naming.registerInstance("test", "11.11.11.11", 8888, "TEST1");
        new CountDownLatch(1).await();
    }
}
