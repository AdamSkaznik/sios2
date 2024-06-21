package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalBranchClosed;
import local.wpr.start.sios.model.HospitalBranchClosedFiles;
import local.wpr.start.sios.repository.HospitalBranchClosedFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class HospitalBranchClosedFilesServiceImpl {
    private static final String UPLOAD_DIR  = "uploadBranchClosed";
    @Autowired
    HospitalBranchClosedFilesRepository hospitalBranchClosedFilesRepository;

//    public HospitalBranchClosedFilesServiceImpl(HospitalBranchClosedFilesRepository hospitalBranchClosedFilesRepository) {
//        this.hospitalBranchClosedFilesRepository = hospitalBranchClosedFilesRepository;
//    }
    public HospitalBranchClosedFiles saveFile(MultipartFile file, HospitalBranchClosed hospitalBranchClosed) throws IOException{
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        if(Files.exists(filePath)){
            throw new IOException("Plik o takiej nazwie istnieje na serwerze!");
        }
        Files.copy(file.getInputStream(), filePath);
        HospitalBranchClosedFiles hospitalBranchClosedFiles = new HospitalBranchClosedFiles();
        hospitalBranchClosedFiles.setFileName(fileName);
        hospitalBranchClosedFiles.setHospitalBranchClosed(hospitalBranchClosed);
        hospitalBranchClosedFiles.setFileUrl(String.valueOf(filePath));
        hospitalBranchClosedFiles.setLocalDateTime(LocalDateTime.now());
        hospitalBranchClosedFiles.setFileActive(true);
        return hospitalBranchClosedFilesRepository.save(hospitalBranchClosedFiles);
    }
    public Path load(String fileName){
        return Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
    }
    public boolean fileExists(String fileName){
        int count = hospitalBranchClosedFilesRepository.countFiles(fileName);
        if(count > 0){
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
            return Files.exists(filePath);
        }
        return Boolean.parseBoolean(null);

    }
}
