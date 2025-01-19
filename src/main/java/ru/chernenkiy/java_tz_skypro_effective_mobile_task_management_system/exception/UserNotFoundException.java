package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
