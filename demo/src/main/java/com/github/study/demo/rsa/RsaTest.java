package com.github.study.demo.rsa;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * CreatedDate: 2021/1/22
 * Author: songjialin
 */
public class RsaTest {
    public static void main(String[] args) throws Exception {
        KeyStore hello = KeyStore.getInstance("hello");
    }

    private static void test3() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyPairGenerator kp = KeyPairGenerator.getInstance("rsa");
        kp.initialize(2048);
        KeyPair keyPair = kp.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        Cipher rsa = Cipher.getInstance("rsa");
        rsa.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] data = new byte[4];
        Arrays.fill(data, (byte) 1);
        byte[] result = rsa.doFinal(data);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
    }

    private static void test2() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyPairGenerator kp = KeyPairGenerator.getInstance("rsa");
        KeyPair keyPair = kp.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        KeyFactory kf = KeyFactory.getInstance("rsa");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(100, new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byteKey = secretKey.getEncoded();
        System.out.println(byteKey.length);
        System.out.println(Hex.toHexString(byteKey));
        byte[] wx = Base64.getDecoder().decode("kCJuo7wizoqZlBDScvywWoS2Rq3d1AnhGh7YOfApsG6");
        System.out.println(wx.length);
        System.out.println(Hex.toHexString(wx));
        byte[] bytes = {1, 2, 3, 4, 5, 6};
        Key key = new SecretKeySpec(bytes, "AES");
        System.out.println(Arrays.toString(key.getEncoded()));
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(bytes);
        System.out.println(Hex.toHexString(result));
    }

    private static void test1(Random random) {
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
    }
}
