package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.exception;

public class TaskAlreadyExistException extends RuntimeException {
  public TaskAlreadyExistException(String message) {
    super(message);
  }
}
