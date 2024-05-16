package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Status;
import local.wpr.start.sios.repository.StatusRepository;
import local.wpr.start.sios.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatusById(Integer statusId) {
        return statusRepository.getReferenceById(statusId);
    }

    @Override
    public void saveStatus(Status status) {
        statusRepository.save(status);
    }
}
