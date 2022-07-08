package com.sai.assignment.service;

import com.sai.assignment.dto.DateTimeDto;
import com.sai.assignment.model.DateTimeJsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DateTimeService {
    private final RestTemplate restTemplate;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public DateTimeDto getDateTime(String area, String location) {
        final String baseUrl = "https://worldtimeapi.org/api/timezone/" + area + "/"+ location;
        DateTimeJsonResponse result = restTemplate.getForObject(baseUrl, DateTimeJsonResponse.class);
        assert result != null;
        LocalDateTime localDateTime
                = ZonedDateTime.parse(result.getDatetime()).toLocalDateTime();
        return DateTimeDto.builder()
                .date(localDateTime.toLocalDate().toString())
                .time(formatter.format(localDateTime.toLocalTime()))
                .build();
    }
}
