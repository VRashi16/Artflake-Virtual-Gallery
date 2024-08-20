package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.ExhibitionDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {

    @Autowired
    private ExhibitionService exhibitionService;

    @GetMapping
    public ResponseEntity<List<ExhibitionDto>> getAllExhibitions() {
        List<ExhibitionDto> exhibitions = exhibitionService.getAllExhibitions();
        return ResponseEntity.status(HttpStatus.OK).body(exhibitions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExhibitionDto> getExhibitionById(@PathVariable("id") Long id) {
        ExhibitionDto exhibition = exhibitionService.getExhibitionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(exhibition);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createExhibition(@RequestBody ExhibitionDto exhibitionDto) {
        ApiResponse response = exhibitionService.createExhibition(exhibitionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateExhibition(@PathVariable("id") Long id, @RequestBody ExhibitionDto exhibitionDto) {
        ApiResponse response = exhibitionService.updateExhibition(id, exhibitionDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteExhibition(@PathVariable("id") Long id) {
        ApiResponse response = exhibitionService.deleteExhibition(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
