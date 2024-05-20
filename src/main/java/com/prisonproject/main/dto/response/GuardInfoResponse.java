package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class GuardInfoResponse {
    private String name;
    private String birthday;
    private String gender;
    private String shift;
    private String startDate;
    private CellInfoWithoutGuardResponse cell;
}
