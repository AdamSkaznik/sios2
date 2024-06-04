package local.wpr.start.sios.controller;

import local.wpr.start.sios.model.MessagesFiles;
import local.wpr.start.sios.service.impl.MessagesFileServiceImpl;
import local.wpr.start.sios.utils.FileInfo;
import local.wpr.start.sios.utils.FilesStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
            messagesFiles.setMessagesFileName(file.getOriginalFilename());
            Path url = Paths.get(context.getRealPath("upload/") + file.getOriginalFilename());
//            String url = context.getContextPath() + "/files/" + file.getOriginalFilename();
            System.out.println("URL: " + url.toString());
            messagesFiles.setFileUrl(url.toString());
            System.out.println("File Name: " +file.getOriginalFilename());
            messagesFileService.saveMessageFiles(messagesFiles);
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

//    @GetMapping("/files/delete/{filename:.+}")
//    public String deleteFile(@PathVariable String filename, Model model, RedirectAttributes redirectAttributes) {
//        try {
//            boolean existed = storageService.delete(filename);
//
//            if (existed) {
//                redirectAttributes.addFlashAttribute("message", "Delete the file successfully: " + filename);
//            } else {
//                redirectAttributes.addFlashAttribute("message", "The file does not exist!");
//            }
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("message",
//                    "Could not delete the file: " + filename + ". Error: " + e.getMessage());
//        }
//
//        return "redirect:/files";
//    }


//    private final String UPLOAD_FOLDER = "/upload";
//    @Autowired
//    MessagesFileServiceImpl messagesFileService;
//
//    @PostMapping("/uploadFiles")
//    public String handleFileUpload(@RequestParam("files")MultipartFile files[], Model map, MessagesFiles messagesFiles){
//       StringBuilder sb = new StringBuilder();
//       for (MultipartFile file: files){
//           if(!file.isEmpty()){
//               try {
//                   if(!Files.exists(Paths.get(UPLOAD_FOLDER))){
//                       try {
//                           Files.createDirectories(Paths.get(UPLOAD_FOLDER));
//                       } catch (IOException ioe) {
//                           LOG.error(ioe.getMessage());
//                       }
//                   }
//                   Files.copy(file.getInputStream(), Paths.get(UPLOAD_FOLDER, file.getOriginalFilename()));
//                   String URL = String.valueOf(Paths.get(UPLOAD_FOLDER, file.getOriginalFilename()));
//                   String description = messagesFiles.getDescription();
//                   messagesFiles.setFileUrl(URL);
//                   messagesFiles.setDescription(description);
//                   messagesFileService.saveMessageFiles(messagesFiles);
//                   sb.append("Pomyślnie dodano plik" +file.getOriginalFilename() + "!\n");
//                   LOG.info("Pomyślnie dodano plik " + file.getOriginalFilename());
//                   map.addAttribute("msg", sb.toString());
//               } catch (IOException | RuntimeException e){
//                   sb.append("Wgranie pliku nie powiodło się "+ (file != null ? file.getOriginalFilename() : "") + "=>" + e.getMessage() + String.valueOf(e) + "\n");
//                   LOG.error("Nie wgrano pliku: " + file.getOriginalFilename() + " z powodu następującego błędu: " + e.getMessage() + String.valueOf(e));
//                   map.addAttribute("msg", sb.toString());
//               }
//
//               } else {
//               sb.append("Nie udało się wgrać pliku\n");
//               map.addAttribute("msg", sb.toString());
//           }
//       }
//       return "uploadFiles";
//    }
}
