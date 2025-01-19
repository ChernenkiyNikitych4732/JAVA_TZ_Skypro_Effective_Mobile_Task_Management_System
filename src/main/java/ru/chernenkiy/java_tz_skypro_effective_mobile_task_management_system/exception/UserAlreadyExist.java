package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String message) {
        super(message);
    }
}
