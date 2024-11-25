package com.nsa.book_nsa.controller;

import com.nsa.book_nsa.model.Format;
import com.nsa.book_nsa.service.FormatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formats")
public class FormatController {

    private final FormatService formatService;

    public FormatController(FormatService formatService) {
        this.formatService = formatService;
    }

    @GetMapping
    public ResponseEntity<?> getAllFormats() {
        List<Format> formats = formatService.getAllFormats();
        return ResponseEntity.ok(formats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormatById(@PathVariable Long id) {
        Format format = formatService.getFormatById(id);
        return ResponseEntity.ok(format);
    }

    @PostMapping
    public ResponseEntity<?> addFormat(@Valid @RequestBody Format format) {
        Format createdFormat = formatService.addFormat(format);
        return ResponseEntity.ok(createdFormat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFormat(@PathVariable Long id, @Valid @RequestBody Format format) {
        Format updatedFormat = formatService.updateFormat(id, format);
        return ResponseEntity.ok(updatedFormat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFormat(@PathVariable Long id) {
        formatService.deleteFormatById(id);
        return ResponseEntity.noContent().build();
    }
}
