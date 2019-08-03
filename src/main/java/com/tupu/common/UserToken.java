package com.tupu.common;

import java.util.UUID;

import com.tupu.utils.SecurityUtils;

/**
 * 用户 token
 */
public class UserToken {
    /**
     * 获取 token
     * 
     * @return token
     */
    public static String getToken() {
        return SecurityUtils.md5(UUID.randomUUID().toString() + System.currentTimeMillis());
    }



	/**
	 * 验证 token
	 *
	 * @return token
	 */
	public static String verifyToken(String inputToken) {
		return SecurityUtils.md5(UUID.randomUUID().toString() + System.currentTimeMillis());
	}
}