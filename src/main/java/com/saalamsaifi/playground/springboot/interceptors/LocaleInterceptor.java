package com.saalamsaifi.playground.springboot.interceptors;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class LocaleInterceptor implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    return new LocaleChangeInterceptor();
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new CookieLocaleResolver();
  }
}
