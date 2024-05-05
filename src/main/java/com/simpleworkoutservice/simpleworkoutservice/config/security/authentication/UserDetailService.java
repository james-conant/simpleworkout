package com.simpleworkoutservice.simpleworkoutservice.config.security.authentication;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import com.simpleworkoutservice.simpleworkoutservice.dao.UserRepository;
import com.simpleworkoutservice.simpleworkoutservice.entity.User;

@Service
public class UserDetailService implements UserDetailsService {

  protected final UserRepository userRepository;

  public UserDetailService(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
    throw new UsernameNotFoundException(username);
  }

  public UserPrincipal loadUserByUsernameAndJwt(String username, Jwt jwt)
      throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByAuthId(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException(username);
    }
    User userObj = user.get();

    return new UserPrincipal(
        userObj);
  }

}
