package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Messages;
import local.wpr.start.sios.model.MessagesFiles;
import local.wpr.start.sios.repository.MessagesFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
public class MessagesFileServiceImpl {
    private static final String UPLOAD_DIR = "uploadAttachment";
    @Autowired
    MessagesFilesRepository messagesFilesRepository;
    public MessagesFiles saveMessagesFiles(MultipartFile file, Messages mess) throws IOException{
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        String filename = file.getOriginalFilename();
        Path filePatch = uploadPath.resolve(filename);
        if(Files.exists(filePatch)){
            throw new IOException("Plik o takiej nazwie już istnieje!");
        }
        Files.copy(file.getInputStream(), filePatch);
        MessagesFiles messagesFiles = new MessagesFiles();
        messagesFiles.setFileName(filename);
        messagesFiles.setFileUrl(String.valueOf(filePatch));
        messagesFiles.setMessageFileActive(true);
        messagesFiles.setMessages(mess);
        return messagesFilesRepository.save(messagesFiles);
    }
    public Path load(String filename){
        return Paths.get(UPLOAD_DIR).resolve(filename).normalize();
    }
    public boolean fileExists(String filename){
        Path filePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();
        return Files.exists(filePath);
    }

    public boolean deleteFile(String filename){
        Path uploadPath = Paths.get(UPLOAD_DIR);
        try {
            Path file = uploadPath.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

//    public MessagesFiles deleteFileServer(MessagesFiles messagesFiles, Messages messages) throws IOException{
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        String fileName = messagesFiles.getFileName();
//        try {
//            Files.delete(Paths.get(fileName));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public MessagesFiles findById(Long id){
//        MessagesFiles messagesFiles = messagesFilesRepository.findById(id);
//        return messagesFiles;
//    }

}
