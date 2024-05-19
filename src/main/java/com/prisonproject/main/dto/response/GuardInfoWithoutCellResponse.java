package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class GuardInfoWithoutCellResponse {
    private String name;
    private String birthday;
    private String gender;
    private String startDate;
}
