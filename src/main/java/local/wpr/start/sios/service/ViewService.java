package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Views;

import java.util.List;

public interface ViewService {
    List<Views> getAllWkrm(Long id);
    List<Views> getById(Long id);

//    Views getOneById(Long id);
}
