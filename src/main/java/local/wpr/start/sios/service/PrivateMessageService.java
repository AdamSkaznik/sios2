package local.wpr.start.sios.service;

import local.wpr.start.sios.model.PrivateMessage;

public interface PrivateMessageService {
    int countPrivateMessages(Long userId);

    PrivateMessage getMy(Long userId);
}
