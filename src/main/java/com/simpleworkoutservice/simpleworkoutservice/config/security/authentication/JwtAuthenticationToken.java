package com.simpleworkoutservice.simpleworkoutservice.config.security.authentication;

import java.util.Map;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;

public class JwtAuthenticationToken extends AbstractOAuth2TokenAuthenticationToken<Jwt> {

  private UserPrincipal principal;

  public JwtAuthenticationToken(Jwt jwt, UserPrincipal principal) {
    super(jwt, principal.getAuthorities());
    this.setAuthenticated(true);
    this.principal = principal;
  }

  protected JwtAuthenticationToken(Jwt token) {
    super(token);
  }

  @Override
  public UserPrincipal getPrincipal() {
    return principal;
  }

  @Override
  public Map<String, Object> getTokenAttributes() {
    return this.getToken().getClaims();
  }
}
