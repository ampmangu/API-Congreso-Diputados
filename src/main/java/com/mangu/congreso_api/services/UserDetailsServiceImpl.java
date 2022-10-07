package com.mangu.congreso_api.services;

import com.mangu.congreso_api.config.security.UserDetailsImpl;
import com.mangu.congreso_api.domain.security.User;
import com.mangu.congreso_api.repository.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(()
            -> new UsernameNotFoundException
            ("user Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
}
