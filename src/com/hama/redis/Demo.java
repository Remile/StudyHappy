package com.hama.redis;

import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import redis.clients.jedis.Jedis;

public class Demo {
	
	private Jedis jedis = null;
	private Connection conn = null;
	
	public static void main(String[] args) throws Exception {
		Demo demo = new Demo();
		demo.setup();
		System.out.println(demo.read("A"));
	}
	
	public String read(String key) throws SQLException {
		String res = "";
		
		res = jedis.get(key);
		if(res == null) {
			String sql = "select id from department where name=?";
			PreparedStatement pps = conn.prepareStatement(sql);
			pps.setString(1, key);
			ResultSet result = pps.executeQuery();
			result.next();
			res = result.getString(1);
			System.out.println("��������mysql");
			jedis.set(key, res);
		}else {
			System.out.println("��������Redis");
		}
		
		return res;
		
	}
	
	public void setup() throws Exception {
		
		// jedis ��¼
		jedis = new Jedis("localhost");
		jedis.auth("root");
		if(jedis != null) {
			System.out.println("Redis ����ɹ�*********");
		}
		
		// mysql ��¼
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/test?"
				+ "user=root&password=root&useUnicode=true&characterEncoding=UTF-8";
		conn = DriverManager.getConnection(url);
		if(conn != null) {
			System.out.println("MySQL ����ɹ�**********");
		}
	}
}
