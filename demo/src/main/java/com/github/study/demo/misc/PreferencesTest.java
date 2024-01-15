package com.github.study.demo.misc;

import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * CreatedDate: 2020/11/3
 * Author: songjialin
 */
public class PreferencesTest {
    public static void main(String[] args) throws BackingStoreException {
        Preferences preferences = Preferences.userRoot().node("google");
        String test = preferences.get("device_id", "def222");
        System.out.println(test);
        preferences = Preferences.userRoot().node("a/b/c/d");
        preferences.put("key", "val");

        preferences.put("aBcD", "hhahahahh");
        System.out.println(preferences.get("aBcD", "def"));

        preferences = Preferences.userRoot().node("groovy/console/ui");
        System.out.println(preferences.get("inputAreaHeight", "def"));
        System.out.println(preferences.absolutePath());
        // preferences = preferences.parent();
        System.out.println(Arrays.toString(preferences.childrenNames()));
        System.out.println(Arrays.toString(preferences.keys()));

        Preferences.userNodeForPackage(AsmTest.class).put("t", "t");
    }
}
