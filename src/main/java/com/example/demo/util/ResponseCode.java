package com.example.demo.util;

import org.apache.http.HttpStatus;

/**
 * 响应码
 */
public abstract class ResponseCode {

    public static final int OK = HttpStatus.SC_OK;
    public static final int BAD_REQUEST = HttpStatus.SC_BAD_REQUEST;
    public static final int UNAUTHORIZED = HttpStatus.SC_UNAUTHORIZED;
    public static final int FORBIDDEN = HttpStatus.SC_FORBIDDEN;
    public static final int METHOD_NOT_ALLOWED = HttpStatus.SC_METHOD_NOT_ALLOWED;
    public static final int NOT_ACCEPTABLE = HttpStatus.SC_NOT_ACCEPTABLE;
}
