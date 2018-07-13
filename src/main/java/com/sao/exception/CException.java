package com.sao.exception;

public class CException extends Exception{

    public String message;
    public int code;

    public CException(int code,String message){
        super(String.valueOf(code));
        this.code = code;
        this.message = message;

    }
}
