package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.HospitalChoice;
import local.wpr.start.sios.repository.HospitalChoiceRepository;
import local.wpr.start.sios.service.HospitalChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalChoiceServiceImpl implements HospitalChoiceService {
    @Autowired
    HospitalChoiceRepository hospitalChoiceRepository;

    public HospitalChoiceServiceImpl(HospitalChoiceRepository hospitalChoiceRepository) {
        this.hospitalChoiceRepository = hospitalChoiceRepository;
    }

    @Override
    public List<HospitalChoice> getAll() {
        return hospitalChoiceRepository.findAll();
    }
}
