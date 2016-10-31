package ru.home.kitchen.service;

/**
 * Created by boris on 01.11.16.
 */
public class KeyGenerator {
    private static KeyGenerator ourInstance = new KeyGenerator();

    public static KeyGenerator getInstance() {
        return ourInstance;
    }

    private KeyGenerator() {
    }
}
