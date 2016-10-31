package ru.home.kitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.home.kitchen.service.KeyService;

import java.math.BigInteger;

@SpringBootApplication
@RestController
public class SmplIgnitePrj4TApplication {

    @Autowired
    KeyService keyService;

    public static void main(String[] args) {
        SpringApplication.run(SmplIgnitePrj4TApplication.class, args);
    }

    @RequestMapping(value = "/{area}/{key}", method = RequestMethod.GET)
    BigInteger getOrPutAndGet(@PathVariable String area, @PathVariable String key) {
        return keyService.getOrPutVal(area,key);
    }
}
