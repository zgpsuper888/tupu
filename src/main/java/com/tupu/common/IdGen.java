package com.tupu.common;

//import java.util.UUID;
import java.util.*;
//import java.text.*;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.security.MessageDigest;
/*
 * Id 生成器 
 * @return String
 */

public class IdGen {  

	public static String getTabId() {
	  	String str = String.valueOf(System.currentTimeMillis());
	    //拼接字符串，并添加2(自定义)位随机数
	    return str + randomNumber(5);
	}
	/**
	 * 生成指定长度的一个数字字符串
	 *
	 * @param num
	 * @return
	 */
	public static String randomNumber(int num) {
	    if (num < 1) {
	        num = 1;
	    }
	    Random random = new Random();
	    StringBuilder str = new StringBuilder();
	    for (int i = 0; i < num; i++) {
	        str.append(random.nextInt(10));
	    }
	    return str.toString();
	}
	
	
}

