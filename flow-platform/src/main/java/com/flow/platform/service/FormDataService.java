package com.flow.platform.service;

import com.flow.platform.entity.FormData;
import java.util.List;

public interface FormDataService {
    List<FormData> getAllFormData();
    FormData getFormDataById(Long formId);
    FormData createFormData(FormData formData);
    FormData updateFormData(Long formId, FormData formData);
    void deleteFormData(Long formId);
}