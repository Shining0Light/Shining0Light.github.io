package com.shininglight.assistant.aaserver.service.impl;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shininglight.assistant.aaserver.configuration.HttpConfig;
import com.shininglight.assistant.aaserver.entity.http.request.LoginReq;
import com.shininglight.assistant.aaserver.entity.http.respon.RespBean;
import com.shininglight.assistant.aaserver.entity.orm.UserCoreEntity;
import com.shininglight.assistant.aaserver.repository.UserCoreRepo;
import com.shininglight.assistant.aaserver.service.BasicOperService;
import com.shininglight.assistant.aaserver.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 16:52 12/05/18
 */
@Service
public class BasicOperServiceImpl implements BasicOperService {


    @Autowired
    private UserCoreRepo userCoreRepo;
    @Override
    public UserCoreEntity findOne(int userId) {
        return userCoreRepo.getUserInfoById(userId);
    }

    public RespBean login(LoginReq loginReq) {
        RespBean rb = new RespBean(HttpConfig.NOT_CHECK_TOKEN, HttpConfig.NOT_CHECK_TOKEN_MSG, null);
        Map map = new HashMap();
        UserCoreEntity u = userCoreRepo.getUserInfoByAcct(loginReq.getAcct());
        if (u == null) {
            map.put("result", "0");
            map.put("msg", "acct is not exist");
            map.put("token", "");
        } else {
            if (!u.getPwd().equals(loginReq.getPwd())) {
                map.put("result", "1");
                map.put("msg", "acct not match pwd");
                map.put("token", "");
            } else {
                map.put("result", "2");
                map.put("msg", "login success");
                String token = TokenUtil.createToken(u.getId(), u.getPwd());
                map.put("token", token);
            }
        }
        rb.setData(map);
        return rb;
    }
}
