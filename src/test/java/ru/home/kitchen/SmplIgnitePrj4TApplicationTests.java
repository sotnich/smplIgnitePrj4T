package ru.home.kitchen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.home.kitchen.ignite.IgniteNode;
import ru.home.kitchen.service.KeyGenerator;
import ru.home.kitchen.service.KeyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {IgniteNode.class,KeyService.class, KeyGenerator.class})
public class SmplIgnitePrj4TApplicationTests {

	@Autowired
	KeyService keyService;

	@Test
	public void contextLoads() {
		assert keyService.getOrPutVal("1","1").intValue()==2;
		assert keyService.getOrPutVal("1","1").intValue()==keyService.getOrPutVal("1","1").intValue();


	}

}
