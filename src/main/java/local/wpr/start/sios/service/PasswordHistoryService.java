package local.wpr.start.sios.service;

import local.wpr.start.sios.model.PasswordHistory;

import java.util.List;

public interface PasswordHistoryService {
    List<PasswordHistory> getByUser(Integer userId);

}
