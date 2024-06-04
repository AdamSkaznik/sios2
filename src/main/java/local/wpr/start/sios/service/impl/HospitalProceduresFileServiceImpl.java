package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalProcedures;
import local.wpr.start.sios.model.HospitalProceduresFile;
import local.wpr.start.sios.repository.HospitalProceduresFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class HospitalProceduresFileServiceImpl {

    private static final String UPLOAD_DIR = "uploadProcedures";
    @Autowired
    HospitalProceduresFileRepository hospitalProceduresFileRepository;

    public HospitalProceduresFile saveHospitalProceduresFile(MultipartFile file, HospitalProcedures procedures) throws IOException{
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        if(file.isEmpty()){

        } else {
            String filename = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath);

            HospitalProceduresFile proceduresFile = new HospitalProceduresFile();
            proceduresFile.setProcedures(procedures);
            proceduresFile.setFileName(filename);
            proceduresFile.setFileUrl(String.valueOf(filePath));
//        proceduresFile.setDescription(filename);
//        proceduresFile.setFileUrl(filePath.toString());
            proceduresFile.setFileActive(true);
            proceduresFile.setLocalDateTime(LocalDateTime.now());
            return hospitalProceduresFileRepository.save(proceduresFile);
        }
//        String filename = file.getOriginalFilename();
//        Path filePath = uploadPath.resolve(filename);
//        Files.copy(file.getInputStream(), filePath);
//
//        HospitalProceduresFile proceduresFile = new HospitalProceduresFile();
//        proceduresFile.setProcedures(procedures);
//        proceduresFile.setFileName(filename);
//        proceduresFile.setFileUrl(String.valueOf(filePath));
////        proceduresFile.setDescription(filename);
////        proceduresFile.setFileUrl(filePath.toString());
//        proceduresFile.setFileActive(true);
//        proceduresFile.setLocalDateTime(LocalDateTime.now());
        return null;
    }
}
