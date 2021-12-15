package com.helloworld.dev.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPAEntity 클래스들이 BaseTimeEntity 를 상속할 경우 아래의 필드를 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity {

    @CreatedDate // Entity 가 생성되어 저장될때 자동으로 시간이 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate//조회한 Entity의 값을 변경할 때 변경한 시간이 자동 저장됨 
    private LocalDateTime modifiedDate;

}
