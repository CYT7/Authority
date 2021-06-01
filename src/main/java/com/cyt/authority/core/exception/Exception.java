package com.cyt.authority.core.exception;

/**
 * @author Chenyt7
 * @Time 2021/5/19
 * @describe: 自定义异常封装
 **/
public class Exception extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;
    private int code = 500;
    public Exception(String msg) {
        super(msg);
        this.msg = msg;
    }
    public Exception(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }
    public Exception(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public Exception(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}