package com.example.webchat;

import com.example.webchat.util.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class WebchatApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {

		redisTemplate.opsForValue().set("sdq","111");
        redisTemplate.delete("cfl");
		Object cfl = redisTemplate.opsForValue().get("cfl");
            if(cfl==null){
			System.out.println("cfl is null");
			redisTemplate.opsForValue().set("cfl","you are cfl");
			redisTemplate.delete("cfl");
            cfl = redisTemplate.opsForValue().get("cfl");
			if(cfl==null){
                System.out.println("cfl is null");
            }else {
                System.out.println(cfl);
            }
		}else{
			System.out.println(cfl);
		}
	}

}
