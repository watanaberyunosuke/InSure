package com.harrybwatson.insure.user.service;

import com.harrybwatson.insure.user.model.AgentUserDetails;
import com.harrybwatson.insure.user.model.User;
import com.harrybwatson.insure.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Implement UserDetailsService from Spring Boot
 */

public class AgentUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new AgentUserDetails(user);
    }
}
