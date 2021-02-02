package com.github.study.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.net.InternetDomainName;

/**
 * CreatedDate: 2021/1/26
 * Author: songjialin
 */
public class BaseTest {
    public static void main(String[] args) {
        InternetDomainName from = InternetDomainName.from("www.50lion.com");
        System.out.println(from.publicSuffix());
        System.out.println(from.isPublicSuffix());
    }

    private static void charMatcher() {
        CharMatcher charMatcher = CharMatcher.anyOf("$");
        System.out.println(charMatcher.collapseFrom("a$b", '1'));
        System.out.println(charMatcher.retainFrom("1$1$1 1 1 1 1 1 1 "));
        System.out.println(charMatcher.trimFrom("$1$"));
        System.out.println(Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,_b_ ,c__"));
    }
}
