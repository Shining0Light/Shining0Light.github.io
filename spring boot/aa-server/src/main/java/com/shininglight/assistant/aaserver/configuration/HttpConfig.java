package com.shininglight.assistant.aaserver.configuration;
/**
 * 与http有关的常量.
 *
 * @author: Shane Liu
 * @date: Created in 14:44 12/05/18
 */
public class HttpConfig {
    //请求响应代码
    public static final int CHECK_TOKEN_SUCCESS = 0;
    public static final int CHECK_TOKEN_FAILED = 1;
    public static final int NOT_CHECK_TOKEN = 2;
    public static final int SERVER_ERROR = 3;

    //请求响应消息
    public static final String CHECK_TOKEN_SUCCESS_MSG = "token validate success";
    public static final String CHECK_TOKEN_FAILED_MSG = "token validate fail:";
    public static final String NOT_CHECK_TOKEN_MSG = "no token validation";
    public static final String SERVER_ERROR_MSG = "server error:";

    //无需验证token的url路径
    public static final String[] NO_VALIATION_PATH = {"/basicOper/login", "/index/hello"};
}
