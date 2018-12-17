package com.shininglight.assistant.aaserver.exception;
import com.shininglight.assistant.aaserver.configuration.HttpConfig;
import com.shininglight.assistant.aaserver.entity.http.respon.RespBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获.
 *
 * @author: Shane Liu
 * @date: Created in 10:31 12/06/18
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleAllException(Exception e) {
        String msg = e.getMessage();
        RespBean respBean = new RespBean();
        respBean.setData("");

        if (e instanceof TokenException) {
            respBean.setCode(HttpConfig.CHECK_TOKEN_FAILED);
            respBean.setMsg(HttpConfig.CHECK_TOKEN_FAILED_MSG + msg);
        } else {
            respBean.setCode(HttpConfig.SERVER_ERROR);
            respBean.setMsg(HttpConfig.SERVER_ERROR_MSG + msg);
        }
        return respBean;
    }
}
