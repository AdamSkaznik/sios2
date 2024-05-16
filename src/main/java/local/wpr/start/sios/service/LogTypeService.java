package local.wpr.start.sios.service;

import local.wpr.start.sios.model.LogType;

import java.util.List;

public interface LogTypeService {
    List<LogType> getAllLogType();
    LogType getByLogTypeId(Integer logTypeId);
    void saveLogType(LogType logType);
}
