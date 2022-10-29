package com.apromac.saigneur.utility;

import com.apromac.saigneur.dto.InterviewDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InterviewRequest {
    private List<InterviewDTO> interviewDTOS;
}
