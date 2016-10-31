package ru.home.kitchen.ignite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteIllegalStateException;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Created by boris on 01.11.16.
 */
@Component
public class IgniteNode {

    private Log log = LogFactory.getLog(IgniteNode.class);
    private final Ignite ignite;


    private IgniteCache<String,BigInteger> cache;
    private boolean started = false;

    public IgniteNode() {
        try {
            Ignition.ignite("node");
            started = true;
        } catch (IgniteIllegalStateException e) {
            log.debug("Using the Ignite instance that has been already started.");
        }
        if (started)
            ignite = Ignition.ignite("node");
        else {

            IgniteConfiguration cfg = new IgniteConfiguration();
            cfg.setClientMode(false);

            ignite = Ignition.start(cfg);
            cache = ignite.getOrCreateCache("keyCache");
//            ((TcpDiscoverySpi) ignite.configuration().getDiscoverySpi())
//                    .getIpFinder()
//                    .registerAddresses(Collections.singletonList(new InetSocketAddress("localhost", 47500)));
        }
    }

    public Ignite getIgnite() {
        return ignite;
    }
    public IgniteCache<String, BigInteger> getCache() {
        return cache;
    }

}
