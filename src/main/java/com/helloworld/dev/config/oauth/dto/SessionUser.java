package com.helloworld.dev.config.oauth.dto;

import com.helloworld.dev.domain.user.User;
import lombok.Getter;

import java.io.Serializable;


@Getter
public class SessionUser implements Serializable {
    //User 클래스를 그대로 세션에 저장하지 않는 이유
    //: 직렬화 때문에
    //User 에 직렬화 코드를 안넣는 이유는?
    //: USer 는 클래스 엔티티이기 때문에 1:N or N:N 등 자식 엔티티를 가지고 있을 경우 직렬화 대상에 자식들까지 다 포함된다.
    // => 성응 시유, 부수 효과 미연에 방지
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
