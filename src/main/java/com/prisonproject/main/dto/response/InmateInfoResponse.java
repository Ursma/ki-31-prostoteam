package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class InmateInfoResponse {
    private String name;
    private String birthday;
    private String gender;
    private String startDate;
    private String endDate;
    private List<CrimeInfoResponse> crimes;
    private CellInfoWithoutInmateResponse cell;
}
