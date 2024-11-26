package com.nsa.book_nsa.controller;

import com.nsa.book_nsa.model.Line;
import com.nsa.book_nsa.service.LineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lines")
public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @GetMapping
    public ResponseEntity<?> getAllLines() {
        List<Line> lines = lineService.getAllLines();
        return ResponseEntity.ok(lines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLineById(@PathVariable Long id) {
        Line line = lineService.getLineById(id);
        return ResponseEntity.ok(line);
    }

    @PostMapping
    public ResponseEntity<?> addLine(@Valid @RequestBody Line line) {
        lineService.addLine(line);
        return ResponseEntity.ok(line);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLine(@PathVariable Long id,@Valid @RequestBody Line line) {
        lineService.updateLine(id, line);
        return ResponseEntity.ok(line);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLine(@PathVariable Long id) {
        lineService.deleteLine(id);
        return ResponseEntity.noContent().build();
    }
}
