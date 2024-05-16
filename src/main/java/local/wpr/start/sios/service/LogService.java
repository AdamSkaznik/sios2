package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Log;

import java.util.List;

public interface LogService {
    List<Log> getAllLog();

    Log getLogById(Long logId);
    void saveLog(Log log);
}
