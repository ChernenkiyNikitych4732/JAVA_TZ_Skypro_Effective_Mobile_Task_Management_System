package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignInRequest {
  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  private String email;

  private String password;
}
