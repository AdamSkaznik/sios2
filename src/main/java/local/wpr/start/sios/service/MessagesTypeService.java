package local.wpr.start.sios.service;

import local.wpr.start.sios.model.MessagesType;

import java.util.List;

public interface MessagesTypeService {
    List<MessagesType> getAllMessagesType();
    MessagesType getMessagesTypeById(Integer messagesTypeId);

    void saveMessagesType(MessagesType messagesType);
}
