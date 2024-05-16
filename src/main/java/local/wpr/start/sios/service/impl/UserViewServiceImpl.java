package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.UserView;
import local.wpr.start.sios.repository.UserViewRepository;
import local.wpr.start.sios.service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserViewServiceImpl implements UserViewService {
    @Autowired
    UserViewRepository userViewRepository;

    public UserViewServiceImpl(UserViewRepository userViewRepository) {
        this.userViewRepository = userViewRepository;
    }

    @Override
    public List<UserView> all(Long id) {
        return userViewRepository.getAll(id);
    }
//
//    @Override
//    public List<UserView> all() {
//        return userViewRepository.getAll();
//    }
}
