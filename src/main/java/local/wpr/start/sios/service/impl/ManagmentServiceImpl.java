package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Managment;
import local.wpr.start.sios.repository.ManagmentRepository;
import local.wpr.start.sios.service.ManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagmentServiceImpl implements ManagmentService {
    @Autowired
    ManagmentRepository managmentRepository;

    public ManagmentServiceImpl(ManagmentRepository managmentRepository) {
        this.managmentRepository = managmentRepository;
    }

    @Override
    public List<Managment> getAllManagment() {
        return managmentRepository.findAll();
    }

    @Override
    public Managment getManagmentById(Long managmentId) {
        return managmentRepository.getReferenceById(managmentId);
    }

    @Override
    public void saveManagment(Managment managment) {
        managmentRepository.save(managment);
    }
}

