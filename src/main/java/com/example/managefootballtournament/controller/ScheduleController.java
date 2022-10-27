package com.example.managefootballtournament.controller;

import com.example.managefootballtournament.domain.ScheduleDTO;
import com.example.managefootballtournament.entity.Schedule;
import com.example.managefootballtournament.geneticAlgorithm.InitCoupleMatch;
import com.example.managefootballtournament.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<Schedule>> getSchedule(@RequestParam(required = false) Integer tournamentId, @RequestParam(required = false) Integer amountIndividual) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.solveSchedule(tournamentId, amountIndividual));
    }

    @PostMapping("/add-schedule")
    public ResponseEntity<Integer> addSchedule(@RequestBody Schedule schedule) {
        return new ResponseEntity<>(scheduleService.addSchedule(schedule), HttpStatus.OK);
    }

    @GetMapping("/detail-tournament")
    public ResponseEntity<List<ScheduleDTO>> displayDetailScheduleOfTournament(@RequestParam(required = false) int tournamentId) {
        return new ResponseEntity<>(scheduleService.findScheduleForTournament(tournamentId), HttpStatus.OK);
    }

    @PostMapping("/tool-schedule")
    public ResponseEntity solveSchedule(@RequestParam(required = false) int tournamentId) {
        return ResponseEntity.ok("");
    }
}

