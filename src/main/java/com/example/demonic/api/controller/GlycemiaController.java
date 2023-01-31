package com.example.demonic.api.controller;

import com.example.demonic.model.entity.Glycemia;
import com.example.demonic.model.repository.GlycemiaRepository;
import com.example.demonic.model.service.GlycemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/v1")
public class GlycemiaController {

    private final GlycemiaService glycemiaService;

    private final GlycemiaRepository glycemiaRepository;

    @Autowired
    GlycemiaController(GlycemiaService glycemiaService, GlycemiaRepository glycemiaRepository) {
        this.glycemiaRepository = glycemiaRepository;
        this.glycemiaService = glycemiaService;
    }

    @GetMapping("/glycemiasearchfordate/{date}")
    public ResponseEntity<Glycemia> listGlycemiaUsingDate (@PathVariable("date") String date) {
        var glycemia = glycemiaService.findGlycemiaByDate(LocalDateTime.parse(date));
        return new ResponseEntity<>(glycemia,HttpStatus.OK);
    }

    @PostMapping("/createglycemicvalue")
    public ResponseEntity<Glycemia> createNewGlycemia (@RequestBody Glycemia glycemia) {
        glycemiaService.createNewGlycemicValue(glycemia);
        return new ResponseEntity<>(glycemia, HttpStatus.OK);
    }

}
