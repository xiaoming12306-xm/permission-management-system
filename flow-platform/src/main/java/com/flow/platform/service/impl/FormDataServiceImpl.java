package com.flow.platform.service.impl;

import com.flow.platform.entity.FormData;
import com.flow.platform.repository.FormDataRepository;
import com.flow.platform.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FormDataServiceImpl implements FormDataService {

    @Autowired
    private FormDataRepository formDataRepository;

    @Override
    public List<FormData> getAllFormData() {
        return formDataRepository.findAll();
    }

    @Override
    public FormData getFormDataById(Long formId) {
        return formDataRepository.findById(formId)
            .orElseThrow(() -> new RuntimeException("表单数据未找到"));
    }

    @Override
    public FormData createFormData(FormData formData) {
        return formDataRepository.save(formData);
    }

    @Override
    public FormData updateFormData(Long formId, FormData formData) {
        FormData existingFormData = getFormDataById(formId);
        existingFormData.setFormType(formData.getFormType());
        existingFormData.setFormData(formData.getFormData());
        return formDataRepository.save(existingFormData);
    }

    @Override
    public void deleteFormData(Long formId) {
        formDataRepository.deleteById(formId);
    }
}