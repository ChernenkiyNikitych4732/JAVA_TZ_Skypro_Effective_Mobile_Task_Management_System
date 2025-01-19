package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDefinitions {

  // Точка среза для регистрации
  @Pointcut("execution(* ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.controller.SecurityController.signup(..))")
  public void signupPointcut() {}

  // Точка среза для входа
  @Pointcut("execution(* ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.controller.SecurityController.signin(..))")
  public void signinPointcut() {}

  @Pointcut("execution(* ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.controller.*.*(..))")
  public void getPointcut() {}
}
