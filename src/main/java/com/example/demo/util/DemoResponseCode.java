package com.example.demo.util;

/**
 * 自定义返回码
 */
public class DemoResponseCode extends ResponseCode {

    //操作失败，新增，修改，删除失败
    public static final int DO_FAIL = 5001;
    //访问的地址没有权限
    public static final int NO_PERMISSION = 5002;
    //检验的数据不存在
    public static final int NO_EXIST = 5003;
    //检验的数据已存在
    public static final int EXIST = 5004;
    //用户不存在
    public static final int USER_NO_EXIST = 5005;
}
