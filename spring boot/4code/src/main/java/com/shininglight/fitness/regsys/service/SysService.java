package com.shininglight.fitness.regsys.service;

import com.shininglight.fitness.regsys.constant.Protocol;
import com.shininglight.fitness.regsys.dao.SysRepository;
import com.shininglight.fitness.regsys.entity.User;
import com.shininglight.fitness.regsys.service.inter.SysServiceInter;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统操作.
 *
 * @author: Shane Liu
 * @date: Created in 18:15 2018/2/3 0003
 */
@Service
public class SysService implements SysServiceInter {

    @Autowired
    private SysRepository sysRepository;

    /**
     * 登录.
     *
     * @param id  用户账号
     * @param pwd 密码
     * @author: Shining Light
     * @date: 19:47 2018/2/3
     */
    @Override
    public Map login(int id, String pwd) {
        User u = (User) sysRepository.findOne(id);
        Map map = new HashMap();
        if (u == null) {       //输入的账号没有在数据库中找到
            map.put("code", Protocol.FAIL);
            map.put("description", "账号不存在");
            map.put("content", "");
        } else {
            if (!u.getPwd().equals(pwd)) { //数据库中的密码与输入的密码不一致
                map.put("code", Protocol.FAIL);
                map.put("description", "账号密码不一致");
                map.put("content", "");
            } else {  //账号密码匹配
                map.put("code", Protocol.SUCCESS);
                map.put("description", "登录成功");
                map.put("content", u);
            }
        }
        return map;
    }

    @Override
    public Object reg(String pwd, String name) {
        return null;
    }

    @Override
    public Object logout() {
        return null;
    }
}
