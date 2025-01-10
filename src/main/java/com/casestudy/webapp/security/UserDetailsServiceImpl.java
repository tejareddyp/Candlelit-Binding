package com.casestudy.webapp.security;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.dao.UserRoleDAO;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUsernameIgnoreCase(username);

        if (user == null) {

            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // spring security configs
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        //Load the user role from database
        List<UserRole> userRoles = userRoleDao.findByUserId(user.getId());

        // Convert user roles into spring granted authorities
        List<GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                accountIsEnabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                springRoles);
    }

    public List<GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


        for (UserRole role : userRoles) {
            
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(authority);
        }

        return authorities;

    }

}
