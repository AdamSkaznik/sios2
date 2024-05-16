package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Messages;
import local.wpr.start.sios.repository.MessagesRepository;
import local.wpr.start.sios.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    public MessagesServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Override
    public List<Messages> getAllMessages() {
        return messagesRepository.findAll();
    }

    @Override
    public Messages getMessagesById(Long messagesId) {
        return messagesRepository.getReferenceById(messagesId);
    }

    @Override
    public void saveMessages(Messages messages) {
        messagesRepository.save(messages);
    }
}
