package com.helloworld.dev.web.dto.survey;

import com.helloworld.dev.domain.survey.Survey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SurveySaveRequestDto {
    private String title;
    private String content;
    private String writer;

    @Builder
    public SurveySaveRequestDto(String title, String content, String writer){
        this.title=title;
        this.content=content;
        this.writer=writer;
    }

    public Survey toEntity(){
        return Survey.builder().title(title).content(content).writer(writer).build();
    }


}
