package ru.home.kitchen.service;

import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.home.kitchen.ignite.IgniteNode;

import java.math.BigInteger;

/**
 * Created by boris on 01.11.16.
 * Key service.
 * For cache key using area_key value.
 */
@Component
@Scope(value = "singleton")
public class KeyService {
    @Autowired
    private IgniteNode node;

    @Autowired
    private KeyGenerator keyGenerator;

    public synchronized BigInteger getOrPutVal(String area,String key){

        IgniteCache<String,BigInteger> cache = node.getCache();

        String bizKey = area + "_"+key;

        if(cache.containsKey(bizKey)) return cache.get(bizKey);

        BigInteger res = keyGenerator.inc();
        cache.put(bizKey,res);

        return res;
    }

}
