package com.simpleworkoutservice.simpleworkoutservice.config.security;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtIssuerValidator;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestOperations;
import com.simpleworkoutservice.simpleworkoutservice.config.security.authentication.JwtAuthenticationConverter;
import com.simpleworkoutservice.simpleworkoutservice.config.security.authentication.UserDetailService;

@Configuration
@EnableWebSecurity
@Slf4j
public class ApplicationSecurityConfig {
  @Value("${spring.profiles.active:}")
  private String activeProfile;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuerUri;

  @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
  private String jwkSetUri;

  @Autowired
  UserDetailService userDetailService;

  private boolean isLocalOrTest() {
    return true;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService);
  }

  @Bean
  public SecurityFilterChain oAuthFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        authorize -> authorize
            .requestMatchers(antMatcher("/actuator/health"))
            .permitAll()
            .requestMatchers(antMatcher("/actuator/info"))
            .permitAll()
            .anyRequest()
            .authenticated());

    // http.exceptionHandling(
    // exceptionHandling -> exceptionHandling.authenticationEntryPoint(
    // (request, response, authException) -> {
    // log.error(
    // String.format("Auth error for endpoint %s", request.getRequestURI()),
    // authException);
    // response.sendError(
    // HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    // }));

    http.oauth2ResourceServer(
        resourceServer -> resourceServer.jwt(
            jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
    return http.build();
  }

  @Bean
  JwtDecoder jwtDecoder(RestTemplateBuilder builder) {
    // only validate token expiration in deployed environments
    OAuth2TokenValidator<Jwt> withIssuer = isLocalOrTest()
        ? new JwtIssuerValidator(issuerUri)
        : JwtValidators.createDefaultWithIssuer(issuerUri);

    // note: the default connection/read timeouts are 500ms, which causes frequent
    // errors.
    // Increasing this to 5s to hopefully mitigate this.
    RestOperations rest = builder
        .setReadTimeout(Duration.ofSeconds(5))
        .setConnectTimeout(Duration.ofSeconds(5))
        .build();

    NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).restOperations(rest).build();
    jwtDecoder.setJwtValidator(withIssuer);

    return jwtDecoder;
  }

  @Bean
  JwtAuthenticationConverter jwtAuthenticationConverter() {
    return new JwtAuthenticationConverter(userDetailService);
  }
}
