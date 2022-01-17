package com.helloworld.dev.service.survey;

import com.helloworld.dev.domain.survey.SurveyRepository;
import com.helloworld.dev.web.dto.survey.SurveySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*설문조사 관리 서비스 */
@Service
@RequiredArgsConstructor
public class SurveyMngService {

    private final SurveyRepository surveyRepository;

    public Long save(SurveySaveRequestDto requestDto){
        return surveyRepository.save(requestDto.toEntity()).getSv_id();
    }

}
