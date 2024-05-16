package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Views;
import local.wpr.start.sios.repository.ViewRepository;
import local.wpr.start.sios.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    ViewRepository viewRepository;

    public ViewServiceImpl(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    @Override
    public List<Views> getAllWkrm(Long id) {
        return viewRepository.findAllWkrm(id);
    }

    @Override
    public List<Views> getById(Long id) {
        return viewRepository.findAllWkrm(id);
    }
}
