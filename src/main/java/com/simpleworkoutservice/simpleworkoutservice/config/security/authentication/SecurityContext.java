package com.simpleworkoutservice.simpleworkoutservice.config.security.authentication;

import com.simpleworkoutservice.simpleworkoutservice.entity.User;
import exception.NotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityContext {
  public static User getCurrentUser() {
    if (SecurityContextHolder.getContext() != null) {
      if (SecurityContextHolder.getContext().getAuthentication() != null) {
        UserPrincipal currentUser = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
            .getPrincipal();
        return currentUser.getUser();
      }

      throw new NotFoundException("Authentication not found.");
    }

    throw new NotFoundException("Context not found.");
  }

}
