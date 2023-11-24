package io.springboot.vodainsure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.springboot.vodainsure.entity.User;
import io.springboot.vodainsure.repository.UserRepository;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

      @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
