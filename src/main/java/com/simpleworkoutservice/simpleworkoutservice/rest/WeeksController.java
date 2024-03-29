package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;
import com.simpleworkoutservice.simpleworkoutservice.service.WeekService.WeekService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeeksController {

    private WeekService weekService;

    @Autowired
    public WeeksController(WeekService weekService) {
        this.weekService = weekService;

    }

    // @GetMapping("/weeks/program/{programId}")
    // public List<Week> getWeeksByProgramId(@PathVariable("programId") int programId) {

    //     List<Week> weeks = weekService.findAllByProgramId(programId);

    //     if (weeks == null) {
    //         throw new RuntimeException("Weeks not found with program id - " + programId);
    //     }

    //     return weeks;
    // }

}
