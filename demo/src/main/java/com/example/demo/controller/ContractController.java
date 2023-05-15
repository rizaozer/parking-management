package com.example.demo.controller;

import com.example.demo.http.ResponseMessage;


import com.example.demo.model.Contract;
import com.example.demo.service.ContractService;
import com.example.demo.zip.ZipEntryHelper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ContractController {

    private ContractService contractService;
    private ZipEntryHelper zipEntryHelper;

    @PostMapping(value = "/subscriptions/contracts")
    public ResponseEntity<ResponseMessage> createNewEmploymentContract(
            @RequestBody MultipartFile subscriptionContract) throws IOException {
        return ResponseEntity.ok()
                .body(contractService.saveNewSubscriptionContract(subscriptionContract));
    }

    @GetMapping(value = "subscriptions/contracts/zip", produces = {"application/zip"})
    public ResponseEntity<byte[]> getAllEmploymentContractsZip() throws IOException {
        List<Contract> subscriptionContracts = contractService.findAllSubscriptionContracts();
        return ResponseEntity.ok()
                .body(ZipEntryHelper.generateZip(subscriptionContracts));
    }

    @GetMapping(value = "subscriptions/contracts/{id}", produces = {"application/zip"})
    public ResponseEntity<byte[]> getSubscriptionContractsByIdAndGenerateZip(@PathVariable(value = "id") final List<Long> ids) throws IOException {
        return ResponseEntity.ok()
                .body(zipEntryHelper.generateZipFromIds(ids));
    }



}
