package com.helloworld.dev.web;


import com.helloworld.dev.service.survey.SurveyMngService;
import com.helloworld.dev.web.dto.survey.SurveySaveRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설문조사 관리 컨트롤러
**/

@RequiredArgsConstructor
@RestController
public class SurveyMngApiController {

    private final SurveyMngService surveyMngService;

    @PostMapping(value = "/survey/mng")
    public Long save(@RequestBody SurveySaveRequestDto requestDto){
        return surveyMngService.save(requestDto);
    }



}
