package com.shininglight.fitness.regsys.service.inter;

import java.util.Map;

/**
 * 系统操作.
 *
 * @author: Shane Liu
 * @date: Created in 19:39 2018/2/3 0003
 */
public interface SysServiceInter {
    public Map login(int id, String pwd);

    public Object reg(String pwd, String name);

    public Object logout();
}
