package com.github.study.demo.misc;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * CreatedDate: 2020/7/15
 * Author: songjialin
 */
public class UdpTest {
    public static void main(String[] args) throws Exception {
        //UDP servers
        InetAddress group = InetAddress.getByName("228.5.6.7");
        MulticastSocket s = new MulticastSocket(6789);
        byte[] arb = new byte[1024];
        s.joinGroup(group);//加入该组
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(arb, arb.length);
            s.receive(datagramPacket);
            System.out.println(arb.length);
            System.out.println(new String(arb));
        }
    }
}
