package com.shininglight.assistant.aaserver.exception;
/**
 * 自定义token验证时的异常.
 *
 * @author: Shane Liu
 * @date: Created in 16:43 12/05/18
 */
public class TokenException extends Exception {
    public TokenException() {
        super();
    }
    public TokenException(String msg) {
        super(msg);
    }
}
