package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.MessagesFiles;
import local.wpr.start.sios.service.impl.MessagesFileServiceImpl;
import local.wpr.start.sios.utils.FileInfo;
import local.wpr.start.sios.utils.FilesStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

//import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    private final static Logger LOG = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    FilesStorageService storageService;
    @Autowired
    MessagesFileServiceImpl messagesFileService;
    @Autowired
    ServletContext context;

    @GetMapping("/restrict/files/new")
    public String newFile(Model model){
        return "/restrict/upload_form";
    }

    @PostMapping("/restrict/files/upload")
    public String uploadFile(Model model, @RequestParam("file") MultipartFile file){
        String message = "";
        try {
            storageService.saveFile(file);
            MessagesFiles messagesFiles = new MessagesFiles();
            messagesFiles.setFileName(file.getOriginalFilename());
            Path url = Paths.get(context.getRealPath("upload/") + file.getOriginalFilename());
//            String url = context.getContextPath() + "/files/" + file.getOriginalFilename();
            System.out.println("URL: " + url.toString());
            messagesFiles.setFileUrl(url.toString());
            System.out.println("File Name: " +file.getOriginalFilename());
//            messagesFileService.saveMessageFiles(messagesFiles);
            message = "Pomyślnie wgrano plik o nazwie: "+file.getOriginalFilename();
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Nie można wgrać pliku o nazwie: " + file.getOriginalFilename() +" z powodu błędu: " + e.getMessage();
            model.addAttribute("message", message);
        }
        return "/restrict/upload_form";
    }

    @GetMapping("/restrict/files")
    public String getListFiles(Model model){
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build().toString();
            System.out.println("Adres url do pliku: " + url);
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        model.addAttribute("files", fileInfos);
        return "/restrict/files";
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("downloadProcedures/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename){
        try {
            Path file = Paths.get("uploadProcedures").resolve(filename).normalize();
            Resource resource = new ByteArrayResource(Files.readAllBytes(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "uploadProcedures; filename=\""+file.getFileName().toString()+"\"")
                    .body(resource);
        }catch (Exception e){
            LOG.error("Błąd podczas pobierania pliku: "+filename, e);
            return ResponseEntity.badRequest().build();
        }
    }

}
