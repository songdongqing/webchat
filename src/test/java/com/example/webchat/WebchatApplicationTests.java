package com.example.webchat;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.webchat.entity.Column;
import com.example.webchat.entity.Coupons;
import com.example.webchat.mapper.MenuMapper;
import com.example.webchat.util.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class WebchatApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private DataSource dataSource;

	@Autowired
	MenuMapper menuMapper;

	@Test
	void contextLoads() throws SQLException {

//		redisTemplate.opsForValue().set("sdq","111");
//        redisTemplate.delete("cfl");
//		Object cfl = redisTemplate.opsForValue().get("cfl");
//            if(cfl==null){
//			System.out.println("cfl is null");
//			redisTemplate.opsForValue().set("cfl","you are cfl");
//			redisTemplate.delete("cfl");
//            cfl = redisTemplate.opsForValue().get("cfl");
//			if(cfl==null){
//                System.out.println("cfl is null");
//            }else {
//                System.out.println(cfl);
//            }
//		}else{
//			System.out.println(cfl);
//		}
	}
	@Test
	void context1(){
//
//        List<Column> columns = menuMapper.getColumn("coupons");
//        for(Column column : columns){
//            System.out.println(column);
//        }
    }

    @Test
    void context2() throws IOException {

//        List<Column> columns = menuMapper.getColumn("coupons");
//        for(Column column : columns){
//            if(column.getName().equals("id")){
//
//            }else{
//                column.setNewName(HttpUtil.transation(column.getName()));
//                column.setTableName("coupons");
//                menuMapper.updateColumn(column);
//            }
//        }
    }

    @Test
    void context3(){



    }
}
