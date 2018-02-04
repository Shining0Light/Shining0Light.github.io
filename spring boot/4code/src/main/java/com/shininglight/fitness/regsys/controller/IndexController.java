package com.shininglight.fitness.regsys.controller;

import com.shininglight.fitness.regsys.service.inter.SysServiceInter;
import java.util.Map;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统启动页的控制器.
 *
 * @author: Shining Light
 * @date: Created in 10:31 2018/2/3
 */

@Controller
public class IndexController {
    @Autowired
    private SysServiceInter sysService;

    /**
     * 返回index.html界面.
     * 用@Controller+@ResponseBody,@RestController返回数据，不是对应视图
     * 用Controller返回视图
     *
     * @author: Shining Light
     * @date: 13:13 2018/2/3
     * @return: index.html视图
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 登录.
     *
     * @param id  账号
     * @param pwd 密码
     * @author: Shane Liu
     * @date: 21:47 2018/2/3 0003
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(int id, String pwd) {
        Map map = sysService.login(id, pwd);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String result = jsonObject.toString();
        return result;
    }
}
