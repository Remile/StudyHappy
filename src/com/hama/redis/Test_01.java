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
		
		// ��ֵ���  �ַ�����
		jedis.set("angle", "Hamaliel");
		System.out.println(jedis.get("angle"));
		
		// ֵ��׷�� ˳���������
		jedis.append("angle", "������");
		System.out.println(jedis.get("angle"));
		
		// ��ֵ��ɾ������ɾ����get����null
		jedis.del("angle");
		System.out.println(jedis.get("angle"));
		
		// ������ֵ�Ĳ���
		jedis.mset("angle","Hamaliel","tel","15245030824"
				,"QQ","1204886776");
		List<String> sList = jedis.mget("angle","tel","QQ");
		Iterator<String> it = sList.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
		
		// ��ֵ����
		jedis.set("num", "10");
		jedis.incr("num");
		System.out.println(jedis.get("num"));
		jedis.decr("num");
		System.out.println(jedis.get("num"));
	}
	
	public void testMap() {
		
		// ����map
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "�ײ���");
		map.put("age", "21");
		map.put("status", "����");
		jedis.hmset("stu_1", map);
		
		// ȡ��
		List<String> list = jedis.hmget("stu_1", "name","age","status");
		System.out.println(list);
		
		// ɾ�������Լ�һϵ�в���
		jedis.hdel("stu_1", "status");
		System.out.println(jedis.hget("stu_1", "status"));
		System.out.println(jedis.hlen("stu_1"));
		System.out.println(jedis.exists("stu_1"));
		System.out.println(jedis.hkeys("stu_1"));
		System.out.println(jedis.hvals("stu_1"));
		
		// һ�ֶ�ȡģʽ
		Iterator<String> sIt = jedis.hkeys("stu_1").iterator();
		while(sIt.hasNext()) {
			String key = sIt.next();
			System.out.println(jedis.hget("stu_1", key));
		}
		
	}
	
	public void testList() {
		// ��ȫ�����
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
