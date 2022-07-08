package com.sai.assignment.controller;

import com.sai.assignment.dto.DateTimeDto;
import com.sai.assignment.service.DateTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timezone")
@RequiredArgsConstructor
public class DateTimeController {
    private final DateTimeService dateTimeService;

    @GetMapping("/{area}/{location}")
    public DateTimeDto get(@PathVariable String area, @PathVariable String location) {
        return dateTimeService.getDateTime(area, location);
    }
}
