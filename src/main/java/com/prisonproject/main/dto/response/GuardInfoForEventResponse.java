package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class GuardInfoForEventResponse {
    private String name;
    private String gender;
    private String startDate;
}
