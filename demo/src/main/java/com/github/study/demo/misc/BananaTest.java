package com.github.study.demo.misc;

import io.leego.banana.BananaUtils;
import org.springframework.util.StopWatch;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * CreatedDate: 2020/9/9
 * Author: songjialin
 */
public class BananaTest {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(BananaUtils.bananaify("Hello, Banana!"));
        SystemInfo systemInfo = new SystemInfo();
        // System.out.println(systemInfo.getOperatingSystem());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("get");
        List<NetworkIF> networkIFs = systemInfo.getHardware().getNetworkIFs();
        stopWatch.stop();
        stopWatch.start("print");
        for (NetworkIF networkIF : networkIFs) {
            System.out.println("================");
            System.out.println(networkIF.getName());
            System.out.println(networkIF.getDisplayName());
            System.out.println(String.join(".", networkIF.getIPv4addr()));
            System.out.println(String.join(".", networkIF.getIPv6addr()));
            System.out.println(networkIF.getMacaddr());
            System.out.println(networkIF.getMTU());
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(InetAddress.getLocalHost().getHostAddress());


    }
}
