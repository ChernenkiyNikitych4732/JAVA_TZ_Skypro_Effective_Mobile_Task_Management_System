package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.RoleList;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {

  @NotBlank(message = "Username is required")
  private String username;

  @NotBlank(message = "Password is required")
  private String password;

  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  private String email;

  @NotNull(message = "Role is required")
  private RoleList role;
}
