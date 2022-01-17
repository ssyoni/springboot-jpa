package com.helloworld.dev.domain.survey;

import com.helloworld.dev.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Survey extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sv_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column
    private int response_cnt;

    @Column
    private int view_cnt;

    @Builder
    public Survey(String title, String content, String writer, int response_cnt, int view_cnt){
        this.title=title;
        this.content = content;
        this.writer=writer;
        this.response_cnt=response_cnt;
        this.view_cnt=view_cnt;
    }


}
