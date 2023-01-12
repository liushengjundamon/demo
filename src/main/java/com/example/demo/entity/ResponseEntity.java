package com.example.demo.entity;

import com.example.demo.util.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回方式实体
 */
public class ResponseEntity<T> {

    /**
     * 状态码，默认为200成功
     */
    private int code = ResponseCode.OK;
    /**
     * 数据
     */
    private T data;
    /**
     * 消息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    /**
     * 详细信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;

    /**
     * 无参构造
     */
    public ResponseEntity() {
        super();
    }

    /**
     * 用于成功返回
     *
     * @param data
     */
    public ResponseEntity(T data) {
        super();
        this.data = data;
    }

    /**
     * 返回状态和消息
     *
     * @param code
     * @param message
     */
    public ResponseEntity(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * 返回状态和数据
     *
     * @param code
     * @param data
     */
    public ResponseEntity(int code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    /**
     * 返回状态、消息、详细信息
     *
     * @param code
     * @param message
     * @param detail
     */
    public ResponseEntity(int code, String message, String detail) {
        super();
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    /**
     * 返回完整构造
     *
     * @param code
     * @param data
     * @param message
     * @param detail
     */
    public ResponseEntity(int code, T data, String message, String detail) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
