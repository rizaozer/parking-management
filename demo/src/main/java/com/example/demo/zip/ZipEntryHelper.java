package com.example.demo.zip;

import com.example.demo.model.Contract;
import com.example.demo.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Configuration
@AllArgsConstructor
public class ZipEntryHelper {

    private ContractService contractService;

    public static byte [] generateZip(List<Contract> subscriptionContracts) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        for (Contract contracts : subscriptionContracts) {
            ZipEntry entry = new ZipEntry(contracts.getFileName());
            entry.setSize(subscriptionContracts.size());
            zos.putNextEntry(entry);
            zos.write(contracts.getData());
        }
        zos.closeEntry();
        zos.close();
        return baos.toByteArray();
    }

    private static void addZipEntry(ZipOutputStream zos, Contract contract) throws IOException {
        ZipEntry entry = new ZipEntry(contract.getFileName());
        entry.setSize(contract.getData().length);
        zos.putNextEntry(entry);
        zos.write(contract.getData());
        zos.closeEntry();
    }

    private static void addNotFoundEntry(ZipOutputStream zos, Long id) throws IOException {
        String fileName = id.toString() + ".txt";
        String message = "Subscription contract not found!";
        File myTxtFile = new File(fileName);
        FileWriter myWriter = new FileWriter(fileName);
        myWriter.write(message);
        myWriter.close();
        ZipEntry entry = new ZipEntry(fileName);
        entry.setSize(message.length());
        zos.putNextEntry(entry);
        zos.write(Files.readAllBytes(myTxtFile.toPath()));
        zos.closeEntry();
    }

    public byte[] generateZipFromIds(List<Long> ids) throws IOException {
        Map<Long, Boolean> map = new HashMap<>();

        for (Long id : ids) {
            if (contractService.findAllSubscriptionContractsById(id).isEmpty()) {
                map.put(id, false);
            } else {
                map.put(id, true);
            }
        }

        List<Long> keyList = new ArrayList<>(map.keySet());

        List<Contract> employmentContracts = contractService.findAllSubscriptionContractsByIds(ids);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        for (int i = 0; i < map.size(); i++) {

            if(map.get(keyList.get(i)) && contractService.findAllSubscriptionContractsById(ids.get(i)).isPresent()) {
                addZipEntry(zos, employmentContracts.get(i));
            } else {
                addNotFoundEntry(zos, ids.get(i));
            }
        }
        zos.closeEntry();
        zos.close();
        return baos.toByteArray();
    }
}
