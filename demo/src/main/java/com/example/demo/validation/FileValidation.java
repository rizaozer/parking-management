package com.example.demo.validation;

import org.springframework.stereotype.Component;

@Component
public class FileValidation {

    public boolean isSupportedExtension(String extension) {
        return extension != null && (
                        extension.equals("docx")
                        || extension.equals("pdf"));
    }
}
