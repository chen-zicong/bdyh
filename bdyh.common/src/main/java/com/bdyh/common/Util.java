package com.bdyh.common;


import java.util.UUID;
public class Util {
    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,
                32);
    }
}
