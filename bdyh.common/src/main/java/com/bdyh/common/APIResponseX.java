package com.bdyh.common;

public class APIResponseX<T>  {
    private static final int CODE_SUCCESS = 0;

    private static final String CODE_FAIL = "fail";

    private int code;
    private T data;
    private String msg;
    private int count;
    public APIResponseX() {

    }



    public APIResponseX(int code, T data,  int count) {
        this.code = code;
        this.data = data;

        this.count = count;
    }


    public static String getCodeFail() {
        return CODE_FAIL;
    }

    public int getCode() {
        return code;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static APIResponseX<Object> success(Object data, Integer count) {
        return new APIResponseX<>(CODE_SUCCESS, data,count);
    }




}
