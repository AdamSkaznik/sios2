package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Role;
import local.wpr.start.sios.model.User;
import local.wpr.start.sios.repository.RoleRepository;
import local.wpr.start.sios.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private List<User> users = new ArrayList<User>();
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, List<User> users, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.users = users;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public User findById(Integer id){ return userRepository.findById(id);}

    public List<User> all() {
        return userRepository.findAll();
    }

    public List<User> getByHospital(Long id){
        return userRepository.findByHospitalId(id);
    }
    public List<Role> getRole() {
        return roleRepository.findAll();
    }
    public User findById(int userId) {
        return userRepository.findById(userId);
    }
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public void changePassword(User user, String newPassword){
        String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setPasswordChangedTime(new Date());
        userRepository.save(user);
    }
}
