package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.SelectView;
import local.wpr.start.sios.repository.SelectViewRepository;
import local.wpr.start.sios.service.SelectViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectViewServiceImpl implements SelectViewService {
    @Autowired
    SelectViewRepository selectViewRepository;

    public SelectViewServiceImpl(SelectViewRepository selectViewRepository) {
        this.selectViewRepository = selectViewRepository;
    }

    @Override
    public List<SelectView> getAll() {
        return selectViewRepository.findAll();
    }
}
