package com.github.study.demo.guava;

import cn.hutool.core.codec.Base64;
import org.apache.tools.ant.filters.StringInputStream;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CreatedDate: 2021/2/25
 * Author: songjialin
 */
public class RsaTest {
    private static String pub = "-----BEGIN PUBLIC KEY-----\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5rM3z+nzLk4/yTF04StHac0gg\n" +
            "UCdPFJ81qTv4pEzBl+mIMyXHdvXUAOztIcrFMWtqMjfaeyCjzTfwKyC6RLICNHhd\n" +
            "FgQRPYrQy/1HLkFgHBKJIE8Rxl6QG2UdtMcxmbATHUY7r8wJjq09peKv8aaSwpaK\n" +
            "3Y/O/VIErQJ21r2uZwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
    private static String pri = "-----BEGIN PRIVATE KEY-----\n" +
            "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALmszfP6fMuTj/JM\n" +
            "XThK0dpzSCBQJ08UnzWpO/ikTMGX6YgzJcd29dQA7O0hysUxa2oyN9p7IKPNN/Ar\n" +
            "ILpEsgI0eF0WBBE9itDL/UcuQWAcEokgTxHGXpAbZR20xzGZsBMdRjuvzAmOrT2l\n" +
            "4q/xppLClordj879UgStAnbWva5nAgMBAAECgYEAlcsbvKFw3KwHjWqeKjPyaVJn\n" +
            "9em0TNBOQXRutYGXiveLqB3bdLg8SvUUL5r7g2sDRYGOHe0HwB5n6pJgrOWO1Wb8\n" +
            "lfLG8hKnba9nxxgCqR0FeAZtWKmbGsu8lSPlkA6C2XrZVAAwjkh74xUKeJjeWQyV\n" +
            "Mh1bKmSC3L221nAt/cECQQDxKmXJeAcfHn0/rfAIZvchRN2q7SYo1jiIL8rHTrTy\n" +
            "VDNoFccJy0S5ysfa/rQmAv0JX1N8fOTMXH0Um9w7ath9AkEAxRiam+4hxzkn3E9i\n" +
            "7KILjWI7pnj43inEvGznjT1bq6T3in1ZrnbDZLKHEFq3zJzMBA9xFQLrH1kSnNaH\n" +
            "NIm7swJALTMQDrmDRC7XtKap9TkvGjoo/Y8i9sZnpAapD7/NpBlp5Rkny8sgH15F\n" +
            "JONV6kXnHOmT4SIbU74F52Xq2ewFlQJAJcamc3Z70ORaiHZKvpH8ZtfKGQkcofAd\n" +
            "fgPdiYuWE1rl+ww1cSPgJV+2VWMd0UDINYsEIIPTrslysM7JUT+I0wJAFhDBKBUD\n" +
            "7GMvXIzepLjVqPBPfNECHNDo1jggAK7NVSn/H+WYw4MZrBB9iF3ffYKC0KbMuTZv\n" +
            "ojxKZyWPNEBkLg==\n" +
            "-----END PRIVATE KEY-----\n";

    public static void main(String[] args) throws IOException {
        byte[] inputs = new PemReader(new InputStreamReader(new StringInputStream(pri)))
                .readPemObject()
                .getContent();
        String encode = Base64.encode(inputs);
        System.out.println(encode);
    }
}
