package com.saalamsaifi.playground.springboot.errorhandling;

import java.util.Map;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

public class CustomizedErrorAttributes extends DefaultErrorAttributes {
  @Override
  public Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(request, includeStackTrace);
    errorAttributes.put("parameters", request.getParameterMap());
    return errorAttributes;
  }
}
