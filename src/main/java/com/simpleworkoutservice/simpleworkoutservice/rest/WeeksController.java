package com.simpleworkoutservice.simpleworkoutservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleworkoutservice.simpleworkoutservice.entity.Week;
import com.simpleworkoutservice.simpleworkoutservice.service.WeekService.WeekService;

import java.util.List;

@RestController
@RequestMapping("/api/week")
public class WeeksController {

    private WeekService weekService;

    @Autowired
    public WeeksController(WeekService weekService) {
        this.weekService = weekService;

    }

    // Add check if userId matches. Eventually we need roles
    @PostMapping
    public Week createWeek(@RequestBody Week newWeek) {
        return weekService.save(newWeek);
    }

    @GetMapping
    public List<Week> getAllWeeks() {
        return weekService.findAll();
    }

    @GetMapping("/{id}")
    public Week getWeek(@PathVariable Long id) {
        return weekService.findById(id);
    }

    @PutMapping("/{id}")
    public Week updateWeek(@PathVariable Long id, @RequestBody Week updatedWeek) {
        return weekService.update(id, updatedWeek);
    }

    @DeleteMapping("/{id}")
    public void deleteWeek(@PathVariable Long id) {
        weekService.deleteById(id);
    }

}
