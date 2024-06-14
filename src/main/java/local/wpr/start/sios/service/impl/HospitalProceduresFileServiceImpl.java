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

    public HospitalProceduresFile saveHospitalProceduresFile(MultipartFile file, HospitalProcedures procedures) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String filename = file.getOriginalFilename();
        Path filePatch = uploadPath.resolve(filename);
        if (Files.exists(filePatch)) {
            throw new IOException("Plik o takiej nazwie już istnieje na serwerze!");
        }
        Files.copy(file.getInputStream(), filePatch);
        HospitalProceduresFile proceduresFile = new HospitalProceduresFile();
        proceduresFile.setFileName(filename);
        proceduresFile.setProcedures(procedures);
        proceduresFile.setFileUrl(String.valueOf(filePatch));
        proceduresFile.setFileActive(true);
        proceduresFile.setLocalDateTime(LocalDateTime.now());
        return hospitalProceduresFileRepository.save(proceduresFile);
    }
    public Path load(String filename){
        return Paths.get(UPLOAD_DIR).resolve(filename).normalize();
    }
    public boolean fileExists(String filename){
        Path filePatch = Paths.get(UPLOAD_DIR).resolve(filename).normalize();
        return Files.exists(filePatch);
    }
}
