package local.wpr.start.sios.service;

import local.wpr.start.sios.model.MessagesFiles;

import java.util.List;

public interface MessagesFileService {
    List<MessagesFiles> getAllMessagesFiles();
    MessagesFiles getMessagesFilesById(Long messagesFileId);
    void saveMessageFiles(MessagesFiles messagesFiles);
}
