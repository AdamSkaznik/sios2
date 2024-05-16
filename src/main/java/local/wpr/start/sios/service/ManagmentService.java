package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Managment;

import java.util.List;

public interface ManagmentService {
    List<Managment> getAllManagment();
    Managment getManagmentById(Long managmentId);
    void saveManagment(Managment managment);
}
