package com.sai.assignment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DateTimeDto {
    private String date;
    private String time;
}
