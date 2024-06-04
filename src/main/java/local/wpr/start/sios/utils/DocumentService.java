package local.wpr.start.sios.utils;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DocumentService {
    private final Path root = Paths.get("./upload");
    
}
