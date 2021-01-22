package com.github.study.rsa;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * CreatedDate: 2021/1/22
 * Author: songjialin
 */
public class RsaTest {
    public static void main(String[] args) throws Exception {

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

    private static void gen(Random random) {
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
    }
}
