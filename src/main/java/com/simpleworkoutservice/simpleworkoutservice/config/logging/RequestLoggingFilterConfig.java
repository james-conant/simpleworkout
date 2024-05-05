package com.simpleworkoutservice.simpleworkoutservice.config.logging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

  @Value("${request.logging.payload:false}")
  private boolean includePayload;

  @Value("${request.logging.query:false}")
  private boolean includeQuery;

  @Value("${request.logging.header:false}")
  private boolean includeHeaders;

  @Bean
  public CommonsRequestLoggingFilter logFilter() {
    CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
    filter.setIncludeQueryString(includeQuery);
    filter.setIncludePayload(includePayload);
    filter.setMaxPayloadLength(10000);
    filter.setIncludeHeaders(includeHeaders);
    return filter;
  }
}
