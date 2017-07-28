package com.example.demo3.auth.service.security;

import com.example.demo3.auth.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by abosii on 7/14/17.
 */
@Service
public class SingleUserDetailService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("Try identify user '{}'" , s);
        return new User(s, new BCryptPasswordEncoder().encode("123456"));
//
//        log.warn("Bla, Bla. User '{}' is not found", s);
//
//        throw new UsernameNotFoundException(s + "aweSome");
    }
}
