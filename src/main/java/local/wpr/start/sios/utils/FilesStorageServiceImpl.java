package local.wpr.start.sios.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FilesStorageServiceImpl  implements FilesStorageService{
    private final Path root = Paths.get("./upload");
    private static final Logger LOG = LoggerFactory.getLogger(FilesStorageServiceImpl.class);
    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            LOG.error("Nie można zainicjować folderu dla upload!");
            throw new RuntimeException("Nie można zainicjować folderu dla uploadu");
        }
    }

    @Override
    public void saveFile(MultipartFile file) {
    try {
       Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
    }catch (Exception e){
        if(e instanceof FileAlreadyExistsException){
            LOG.error("Plik o takiej nazwie już istnieje!");
            throw new RuntimeException("Plik o takiej nazwie już istnieje!");
        }
        LOG.error("Wystąpił błąd: " + e.getMessage());
        throw new RuntimeException(e.getMessage());
    }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            } else {
                throw new RuntimeException("Plik nie do odczytu");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteFile(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
