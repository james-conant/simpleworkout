package com.simpleworkoutservice.simpleworkoutservice.config.security.authentication;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;

public class JwtAuthenticationConverter implements Converter<Jwt, JwtAuthenticationToken> {

  private final UserDetailService userDetailsService;

  public JwtAuthenticationConverter(UserDetailService userDetailService) {
    this.userDetailsService = userDetailService;
  }

  @Override
  public JwtAuthenticationToken convert(Jwt jwt) {
    String username = jwt.getClaimAsString("sub"); // in this case the username is in the "sub" claim
    UserPrincipal userDetails = userDetailsService.loadUserByUsernameAndJwt(username, jwt);

    return new JwtAuthenticationToken(jwt, userDetails);
  }
}
