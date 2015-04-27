package com.hama.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Test_01 {
	
	private Jedis jedis;
	
	public void setup() {
		jedis = new Jedis("localhost");
		jedis.auth("root");
	}
	
	public void testString() {
		
		// 键值添加  字符串型
		jedis.set("angle", "Hamaliel");
		System.out.println(jedis.get("angle"));
		
		// 值的追加 顺便测试中文
		jedis.append("angle", "哈马琉");
		System.out.println(jedis.get("angle"));
		
		// 键值的删除，被删除后get返回null
		jedis.del("angle");
		System.out.println(jedis.get("angle"));
		
		// 批量键值的操作
		jedis.mset("angle","Hamaliel","tel","15245030824"
				,"QQ","1204886776");
		List<String> sList = jedis.mget("angle","tel","QQ");
		Iterator<String> it = sList.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
		
		// 数值操作
		jedis.set("num", "10");
		jedis.incr("num");
		System.out.println(jedis.get("num"));
		jedis.decr("num");
		System.out.println(jedis.get("num"));
	}
	
	public void testMap() {
		
		// 存入map
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "雷博生");
		map.put("age", "21");
		map.put("status", "单身");
		jedis.hmset("stu_1", map);
		
		// 取出
		List<String> list = jedis.hmget("stu_1", "name","age","status");
		System.out.println(list);
		
		// 删除单键以及一系列测试
		jedis.hdel("stu_1", "status");
		System.out.println(jedis.hget("stu_1", "status"));
		System.out.println(jedis.hlen("stu_1"));
		System.out.println(jedis.exists("stu_1"));
		System.out.println(jedis.hkeys("stu_1"));
		System.out.println(jedis.hvals("stu_1"));
		
		// 一种读取模式
		Iterator<String> sIt = jedis.hkeys("stu_1").iterator();
		while(sIt.hasNext()) {
			String key = sIt.next();
			System.out.println(jedis.hget("stu_1", key));
		}
		
	}
	
	public void testList() {
		// 安全性清空
		jedis.del("myList");
		
		System.out.println(jedis.lrange("myList", 0, -1));
		jedis.lpush("myList", "one");
		jedis.lpush("myList", "two");
		jedis.lpush("myList", "three");
		jedis.lpush("myList", "four");
		System.out.println(jedis.lrange("myList", 0, -1));
	}
	
	public static void main(String[] args) {
		Test_01 test = new Test_01();
		test.setup();
//		test.testString();
//		test.testMap();
		test.testList();
	}
}
