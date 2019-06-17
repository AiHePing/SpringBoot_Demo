package com.eastcom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTest {
	
	@Autowired
	private Jedis jedis;
	
	@Test
	public void show() {
		System.out.println(jedis.ping());
		jedis.set("starter", "myJedis");
		System.out.println(jedis.get("starter"));
	}
}
