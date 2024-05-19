package com.prisonproject.main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class EventInfoResponse {
    private String name;
    private String description;
    private List<InmateInfoForEventResponse> inmates;
    private List<GuardInfoWithoutCellResponse> guards;
}
