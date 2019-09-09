package com.volunt.message.tools;
/**
 * 目的为了解决返回的请求体结构问题而构造的辅助对象
 * @param <T> 该变量是各种返回的data数据，如果没有返回的data数据就为null值
 */
public class UniversalResponseBody<T> {
    private int Code;

    private String msg;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMsg() {
        return msg;
    }

    public UniversalResponseBody(int Code, String msg, T data) {
        this.Code = Code;
        this.msg = msg;
        this.data = data;
    }

    public UniversalResponseBody(int Code, String msg) {
        this.Code = Code;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}
