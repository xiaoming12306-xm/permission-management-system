package com.example.permissionsystem.controller;

import com.example.permissionsystem.model.FormData;
import com.example.permissionsystem.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forms")
public class FormDataController {

  @Autowired private FormDataService formDataService;

  @PostMapping
  public FormData createFormData(@RequestBody FormData formData) {
    return formDataService.save(formData);
  }

  @GetMapping("/{id}")
  public FormData getFormData(@PathVariable Long id) {
    return formDataService.findById(id);
  }
}
