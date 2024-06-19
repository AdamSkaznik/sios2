package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Messages;

import java.util.List;

public interface MessagesService {
    List<Messages> getAllMessages();
    Messages getMessagesById(Long messagesId);

   Messages saveMessages(Messages messages);

   List<Messages> getActiveMessages();
}
