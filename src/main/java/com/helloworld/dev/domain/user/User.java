package com.helloworld.dev.domain.user;

import com.helloworld.dev.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    /*
    JPA로 디비에 저장될 때 ENum 값을 어떤 형태로 저장될지 결정한다.
    기본은 int형으로 저장된다.
    */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }

    public User update(String name, String email){
        this.name=name;
        this.email=email;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


}
