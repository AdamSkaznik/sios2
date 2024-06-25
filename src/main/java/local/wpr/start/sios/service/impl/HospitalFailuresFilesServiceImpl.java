package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalFailures;
import local.wpr.start.sios.model.HospitalFailuresFiles;
import local.wpr.start.sios.repository.HospitalFailuresFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class HospitalFailuresFilesServiceImpl {
private static final String UPLOAD_DIR = "uploadFailuresFiles";
@Autowired
    HospitalFailuresFilesRepository hospitalFailuresFilesRepository;

public HospitalFailuresFiles saveFiles(MultipartFile file, HospitalFailures hospitalFailures)throws IOException {
    Path uploadPath = Paths.get(UPLOAD_DIR);
    if(!Files.exists(uploadPath)){
        Files.createDirectories(uploadPath);
    }
    String fileName = file.getOriginalFilename();
    Path filePath = uploadPath.resolve(fileName);
    if(Files.exists(filePath)){
        throw new IOException("Plik o takiej nazwie już istnieje na serwerze!");
    }
    Files.copy(file.getInputStream(), filePath);
    HospitalFailuresFiles hospitalFailuresFiles = new HospitalFailuresFiles();
    hospitalFailuresFiles.setFileName(fileName);
    hospitalFailuresFiles.setHospitalFailures(hospitalFailures);
    hospitalFailuresFiles.setFileUrl(String.valueOf(filePath));
    hospitalFailuresFiles.setFileActive(true);
    hospitalFailuresFiles.setLocalDateTime(LocalDateTime.now());
    return hospitalFailuresFilesRepository.save(hospitalFailuresFiles);
}
public Path load(String fileName){
    return Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
}
public boolean fileExists(String fileName){
    int count = hospitalFailuresFilesRepository.countFiles(fileName);
    if(count > 0){
        Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
        return Files.exists(filePath);
    }
    return Boolean.parseBoolean(null);
}
}
