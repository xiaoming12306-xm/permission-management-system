package com.flow.platform.controller;

import com.flow.platform.entity.FormData;
import com.flow.platform.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/form-data")
public class FormDataController {

    @Autowired
    private FormDataService formDataService;

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<FormData>> getAllFormData() {
        return ResponseEntity.ok(formDataService.getAllFormData());
    }

    @GetMapping("/{formId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FormData> getFormDataById(@PathVariable Long formId) {
        return ResponseEntity.ok(formDataService.getFormDataById(formId));
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FormData> createFormData(@RequestBody FormData formData) {
        return ResponseEntity.ok(formDataService.createFormData(formData));
    }

    @PutMapping("/{formId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FormData> updateFormData(@PathVariable Long formId, @RequestBody FormData formData) {
        return ResponseEntity.ok(formDataService.updateFormData(formId, formData));
    }

    @DeleteMapping("/{formId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFormData(@PathVariable Long formId) {
        formDataService.deleteFormData(formId);
        return ResponseEntity.noContent().build();
    }
}