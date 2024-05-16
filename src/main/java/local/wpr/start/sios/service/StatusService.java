package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatus();

    Status getStatusById(Integer statusId);
    void saveStatus(Status status);
}
