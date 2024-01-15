package com.github.study.demo.misc;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/**
 * CreatedDate: 2021/2/4
 * Author: songjialin
 */
public class NetTest {
    public static void main(String[] args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        if (interfaces != null) {
            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                boolean up = network.isUp();
                if (!up) {
                    continue;
                }
                System.out.println("=================================");
                System.out.println("isUp:" + up);
                System.out.println("name:" + network.getDisplayName());
                System.out.println("isPointToPoint:" + network.isPointToPoint());
                System.out.println("isLoopback:" + network.isLoopback());
                System.out.println("isVirtual:" + network.isVirtual());
                Enumeration<InetAddress> addresses = network.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    System.out.println("-----------------------------------");
                    InetAddress address = addresses.nextElement();
                    System.out.println(address);
                }
            }
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        List<NetworkIF> networkIFs = hal.getNetworkIFs();
        for (NetworkIF networkIF : networkIFs) {
            System.out.println(networkIF.getName());
            NetworkInterface networkInterface = networkIF.queryNetworkInterface();
        }
    }
}
