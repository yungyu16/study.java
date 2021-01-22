package com.github.study.rsa;

import java.security.*;
import java.util.Random;

/**
 * CreatedDate: 2021/1/22
 * Author: songjialin
 */
public class RsaTest {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(4096, new SecureRandom());
        KeyPair kp = kpg.genKeyPair();
        PrivateKey pri = kp.getPrivate();
        PublicKey pub = kp.getPublic();
        System.out.println(pri.getFormat());
        System.out.println(pub.getFormat());
        KeyFactory kf = KeyFactory.getInstance("rsa");


    }

    private static void gen(Random random) {
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
    }
}
