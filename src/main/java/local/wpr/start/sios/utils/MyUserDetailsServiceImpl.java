package local.wpr.start.sios.utils;

import local.wpr.start.sios.model.Role;
import local.wpr.start.sios.model.User;
import local.wpr.start.sios.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    public static final Logger LOG = LoggerFactory.getLogger(MyUserDetailsServiceImpl.class);
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("UserName przekazane: " + userName);
        try {
            User user = userService.findUserByUserName(userName);
        } catch (Exception e){
           LOG.error("Błąd : " + e.getMessage());
        }
        User user = userService.findUserByUserName(userName);
        System.out.println("User: " + user);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        System.out.println("Role : " + authorities);
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);

    }
}
