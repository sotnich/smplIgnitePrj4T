package ru.home.kitchen.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Created by boris on 01.11.16.
 */
@Component
@Scope(value = "singleton")
public class KeyGenerator {
    private static KeyGenerator ourInstance = new KeyGenerator();

    private BigInteger key= BigInteger.ONE;

    public static KeyGenerator getInstance() {
        return ourInstance;
    }

    private KeyGenerator() {
    }

    public synchronized BigInteger inc(){
        key = key.add(BigInteger.ONE);
        return key;
    }
}
