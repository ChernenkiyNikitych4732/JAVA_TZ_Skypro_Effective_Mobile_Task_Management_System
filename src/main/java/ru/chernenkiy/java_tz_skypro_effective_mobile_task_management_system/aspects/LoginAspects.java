package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.aspects;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto.SignInRequest;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto.SignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoginAspects {

  @AfterReturning(
      value = "ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.aspects.PointcutDefinitions.signupPointcut()",
      returning = "result")
  public void logSignup(JoinPoint joinPoint, Object result) {
    Object[] args = joinPoint.getArgs();
    for (Object obj : args) {
      if (obj instanceof SignUpRequest signupRequest) {
        String username = signupRequest.getUsername();
        log.info("User '{}' registered successfully", username);
      }
    }
  }

  @AfterReturning(
      value = "ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.aspects.PointcutDefinitions.signinPointcut()",
      returning = "result")
  public void logSignin(JoinPoint joinPoint, Object result) {
    Object[] args = joinPoint.getArgs();
    for (Object obj : args) {
      if (obj instanceof SignInRequest signInRequest) {
        String email = signInRequest.getEmail();
        log.info("User with email '{}' logged in successfully", email);
      }
    }
  }

  @Before("ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.aspects.PointcutDefinitions.getPointcut()")
  public void logGetCall(JoinPoint joinPoint) {
    String signatureMethod = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    log.info("Method {} was called with arguments {}", signatureMethod, args);
  }
}
