package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Log;
import local.wpr.start.sios.repository.LogRepository;
import local.wpr.start.sios.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> getAllLog() {
        return logRepository.findAll();
    }

    @Override
    public Log getLogById(Long logId) {
        return logRepository.getReferenceById(logId);
    }

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }
}
