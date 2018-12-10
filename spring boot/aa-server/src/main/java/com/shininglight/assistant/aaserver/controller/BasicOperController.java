package com.shininglight.assistant.aaserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shininglight.assistant.aaserver.entity.http.request.LoginReq;
import com.shininglight.assistant.aaserver.entity.http.respon.RespBean;
import com.shininglight.assistant.aaserver.service.BasicOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 与授权（登录退出等）有关的接口.
 *
 * @author: Shane Liu
 * @date: Created in 14:44 12/05/18
 */
@Controller
@RequestMapping(value = "/basicOper")
public class BasicOperController {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private BasicOperService basicOperService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RespBean login(@RequestBody LoginReq loginReq) {
        RespBean rb =  basicOperService.login(loginReq);
        return rb;
    }
}

