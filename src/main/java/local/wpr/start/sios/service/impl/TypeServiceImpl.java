package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Type;
import local.wpr.start.sios.repository.TypeRepository;
import local.wpr.start.sios.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> getAllType() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(Integer typeId) {
        return typeRepository.getReferenceById(typeId);
    }

    @Override
    public void saveType(Type type) {
        typeRepository.save(type);
    }
}
