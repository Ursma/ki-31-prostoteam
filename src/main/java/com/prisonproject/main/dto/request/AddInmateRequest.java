package com.prisonproject.main.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddInmateRequest {
    private String name;
    private LocalDate birthday;
    private Integer gender;
    private LocalDate startDate;
    private List<String> crimeNumbers;
    private String cellName;
}
