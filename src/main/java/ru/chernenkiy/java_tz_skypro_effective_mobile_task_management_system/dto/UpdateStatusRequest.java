package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateStatusRequest {
  @NotNull(message = "Status is required")
  private TaskStatus status;
}
