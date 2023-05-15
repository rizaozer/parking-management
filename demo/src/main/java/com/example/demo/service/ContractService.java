package com.example.demo.service;

import com.example.demo.http.ResponseMessage;
import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.validation.FileValidation;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ContractService {

    private FileValidation fileValidation;
    private ContractRepository contractRepository;

    @Transactional
    public ResponseMessage saveNewSubscriptionContract(MultipartFile file) throws IOException {

        String message;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = FilenameUtils.getExtension(fileName);

        if (fileValidation.isSupportedExtension(extension)) {
            Contract contract = new Contract(fileName, file.getContentType(), file.getBytes());
            contractRepository.save(contract);
            message = "Employment Contract Uploaded successfully: " + fileName;
        } else {
            message = "Could not upload the file: " + fileName;
        }
        return new ResponseMessage(message);
    }

    @Transactional
    public List<Contract> findAllSubscriptionContracts() {
        return contractRepository.findAll();
    }

    @Transactional
    public Optional<Contract> findAllSubscriptionContractsById(Long id) {
        return contractRepository.findById(id);
    }

    @Transactional
    public List<Contract> findAllSubscriptionContractsByIds(List<Long> ids) {
        return contractRepository.findAllById(ids);
    }

}
