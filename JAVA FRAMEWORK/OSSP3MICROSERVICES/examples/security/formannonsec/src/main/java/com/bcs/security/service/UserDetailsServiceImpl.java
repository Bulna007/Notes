package com.bcs.security.service;

import com.bcs.entities.User;
import com.bcs.repositories.UserRepository;
import com.bcs.security.beans.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        UserDetails userDetails = null;

        user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("username : "+ username + " not found");
        }
        userDetails = new UserDetailsImpl(user.getSystemUserId(), user.getUsername(), user.getPassword(), user.getRole().getRoleName(), user.getStatus());
        return userDetails;
    }
}
