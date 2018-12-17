package com.shininglight.assistant.aaserver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shininglight.assistant.aaserver.entity.orm.UserCoreEntity;
import com.shininglight.assistant.aaserver.exception.TokenException;
import com.shininglight.assistant.aaserver.service.BasicOperService;
import com.shininglight.assistant.aaserver.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 验证token的过滤器.
 *
 * @author: Shane Liu
 * @date: Created in 16:28 12/05/18
 */


public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private BasicOperService userCoreService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws TokenException {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token

        // 获取token中的userAcct
        int userId = TokenUtil.getUserIdFromToken(token);
        // 通过userAcct查询pwd
        UserCoreEntity u = userCoreService.findOne(userId);
        // 验证token
        TokenUtil.validateToken(u.getPwd(), token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
