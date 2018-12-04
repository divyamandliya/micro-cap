package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.model.Item;

@Configuration
public class RedisConfig {
	

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Item> redisTemplate() {
	    final RedisTemplate<String, Item> template = new RedisTemplate<String, Item>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}

}
