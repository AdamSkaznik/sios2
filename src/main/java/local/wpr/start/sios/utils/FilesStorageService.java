package local.wpr.start.sios.utils;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
    public void init();
    public void saveFile(MultipartFile file);
    public Resource load(String filename);
    public boolean deleteFile(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}
