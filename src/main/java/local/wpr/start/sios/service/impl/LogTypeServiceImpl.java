package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.LogType;
import local.wpr.start.sios.repository.LogTypeReporitory;
import local.wpr.start.sios.service.LogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogTypeServiceImpl implements LogTypeService {
    @Autowired
    LogTypeReporitory logTypeReporitory;

    public LogTypeServiceImpl(LogTypeReporitory logTypeReporitory) {
        this.logTypeReporitory = logTypeReporitory;
    }

    @Override
    public List<LogType> getAllLogType() {
        return logTypeReporitory.findAll();
    }

    @Override
    public LogType getByLogTypeId(Integer logTypeId) {
        return logTypeReporitory.getReferenceById(logTypeId);
    }

    @Override
    public void saveLogType(LogType logType) {
        logTypeReporitory.save(logType);
    }
}
