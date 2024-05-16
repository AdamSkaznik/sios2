package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.MessagesType;
import local.wpr.start.sios.repository.MessagesTypeRepository;
import local.wpr.start.sios.service.MessagesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesTypeServiceImpl implements MessagesTypeService {
    @Autowired
    MessagesTypeRepository messagesTypeRepository;

    public MessagesTypeServiceImpl(MessagesTypeRepository messagesTypeRepository) {
        this.messagesTypeRepository = messagesTypeRepository;
    }

    @Override
    public List<MessagesType> getAllMessagesType() {
        return messagesTypeRepository.findAll();
    }

    @Override
    public MessagesType getMessagesTypeById(Integer messagesTypeId) {
        return messagesTypeRepository.getReferenceById(messagesTypeId);
    }

    @Override
    public void saveMessagesType(MessagesType messagesType) {
        messagesTypeRepository.save(messagesType);
    }
}
