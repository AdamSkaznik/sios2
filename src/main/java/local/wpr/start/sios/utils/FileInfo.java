package local.wpr.start.sios.utils;

public class FileInfo {
    private String name;
    private String url;
    private String fileDescription;

    public FileInfo(String name, String url, String fileDescription) {
        this.name = name;
        this.url = url;
        this.fileDescription = fileDescription;
    }

    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }
}
