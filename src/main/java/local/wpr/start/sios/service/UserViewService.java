package local.wpr.start.sios.service;

import local.wpr.start.sios.model.UserView;

import java.util.List;

public interface UserViewService {
    List<UserView> all(Long id);
}
