package com.helloworld.dev.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

// 스프링 시큐리티에서는 모든 권한은 ROLE_이 앞에 있어야한다.
    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;

}
