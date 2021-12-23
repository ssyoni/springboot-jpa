package com.helloworld.dev.config;

import com.helloworld.dev.config.oauth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // HandlerMethodArgumentResolever 는 항상 WebMvsConfigurer 의 addArgumentResolvers롤 통해서 추가해야함.
        // 다른 HandlerMethodArgumentResolever 가 필요하다면 같은 방식으로 추가해주면 된다.
        resolvers.add(loginUserArgumentResolver);
    }
}
