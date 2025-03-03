package com.example.permissionsystem.service;

import com.example.permissionsystem.model.FormData;
import com.example.permissionsystem.repository.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormDataService {
  @Autowired private FormDataRepository formDataRepository;

  public FormData save(FormData formData) {
    return formDataRepository.save(formData);
  }

  public FormData findById(Long id) {
    return formDataRepository.findById(id).orElse(null);
  }
}
