package com.shininglight.assistant.aaserver.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.shininglight.assistant.aaserver.entity.http.request.LoginReq;
import com.shininglight.assistant.aaserver.entity.http.respon.RespBean;
import com.shininglight.assistant.aaserver.entity.orm.UserCoreEntity;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 16:52 12/05/18
 */
public interface BasicOperService {
    UserCoreEntity findOne(int userId);
    RespBean login(LoginReq loginReq);
}
