package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAllType();

    Type getTypeById(Integer typeId);

    void saveType(Type type);
}
