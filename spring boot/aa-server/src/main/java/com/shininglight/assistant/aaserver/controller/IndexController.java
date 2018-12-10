package com.shininglight.assistant.aaserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 用于测试的接口.
 * @author: Shane Liu
 * @date: Created in 14:44 12/05/18
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String echoTest() {
        return "hi";
    }

}

