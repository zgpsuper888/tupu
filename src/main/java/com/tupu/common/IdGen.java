package com.tupu.common;

import java.util.Random;

public class IdGen {

    public static long getUniqueId() {
        // 拼接字符串，并添加2(自定义)位随机数
        return Long.valueOf(System.currentTimeMillis() + randomNumber(5));
    }

    private static String randomNumber(int num) {
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
