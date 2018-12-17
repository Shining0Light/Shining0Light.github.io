package com.shininglight.assistant.aaserver.configuration;
import com.shininglight.assistant.aaserver.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 添加并配置过滤器.
 *
 * @author: Shane Liu
 * @date: Created in 17:23 12/05/18
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthenticationInterceptor getAuthenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(HttpConfig.NO_VALIATION_PATH); //放掉某些特定不需要校验token的路由
    }


}
