package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.exception.ControllerExceptionHandler;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto.ResponseError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

  private final ControllerExceptionHandler controllerExceptionHandler;

  public MyAccessDeniedHandler(ControllerExceptionHandler controllerExceptionHandler) {
    this.controllerExceptionHandler = controllerExceptionHandler;
  }

  @Override
  public void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException accessDeniedException)
      throws IOException, ServletException {
    WebRequest webRequest = new ServletWebRequest(request);
    ResponseError error =
        controllerExceptionHandler.handleSpringAccessDeniedException(
            accessDeniedException, webRequest);
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    response.setContentType("application/json");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.writeValue(response.getWriter(), error);
  }
}
