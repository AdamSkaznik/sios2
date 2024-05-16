package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.PrivateMessage;
import local.wpr.start.sios.repository.PrivateMessageRepository;
import local.wpr.start.sios.service.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {
    @Autowired
    PrivateMessageRepository privateMessageRepository;

    public PrivateMessageServiceImpl(PrivateMessageRepository privateMessageRepository) {
        this.privateMessageRepository = privateMessageRepository;
    }

    @Override
    public int countPrivateMessages(Long userId) {
        return privateMessageRepository.countPrivateMessages(userId);
    }

    @Override
    public PrivateMessage getMy(Long userId) {
        return privateMessageRepository.getPrivateMessage(userId);
    }
}
