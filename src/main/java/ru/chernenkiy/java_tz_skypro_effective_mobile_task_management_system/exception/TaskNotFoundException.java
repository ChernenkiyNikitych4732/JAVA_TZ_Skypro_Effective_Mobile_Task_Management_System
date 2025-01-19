package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.exception;

public class TaskNotFoundException extends RuntimeException {
  public TaskNotFoundException(String message) {
    super(message);
  }
}
