package com.github.study.java;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * CreatedDate: 2020/7/15
 * Author: songjialin
 */
public class UdpTest2 {
    public static void main(String[] args) throws Exception {
        //UDP sender
        int port = 6789;
        String sendMessage = "hello multicast";
        InetAddress inetAddress = InetAddress.getByName("228.5.6.7");
        DatagramPacket datagramPacket = new DatagramPacket(sendMessage.getBytes(), sendMessage.length(), inetAddress, port);
        MulticastSocket multicastSocket = new MulticastSocket(); //it is client, it won't join group
        multicastSocket.send(datagramPacket);
    }
}
