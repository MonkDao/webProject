package com.prototype.first.configs;


import com.prototype.first.entity.User;
import com.prototype.first.entity.UserRole;
import com.prototype.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
//    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        return getByUser(user);
    }

    private Principle getByUser(User user) {
        Set<UserRole> roles = user.getRoles();
        return new Principle(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), roles);
    }
}
