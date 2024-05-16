package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.MessagesFiles;
import local.wpr.start.sios.repository.MessagesFilesRepository;
import local.wpr.start.sios.service.MessagesFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesFileServiceImpl implements MessagesFileService {
    @Autowired
    MessagesFilesRepository messagesFilesRepository;

    public MessagesFileServiceImpl(MessagesFilesRepository messagesFilesRepository) {
        this.messagesFilesRepository = messagesFilesRepository;
    }

    @Override
    public List<MessagesFiles> getAllMessagesFiles() {
        return messagesFilesRepository.findAll();
    }

    @Override
    public MessagesFiles getMessagesFilesById(Long messagesFileId) {
        return messagesFilesRepository.getReferenceById(messagesFileId);
    }

    @Override
    public void saveMessageFiles(MessagesFiles messagesFiles) {
        messagesFilesRepository.save(messagesFiles);
    }
}
