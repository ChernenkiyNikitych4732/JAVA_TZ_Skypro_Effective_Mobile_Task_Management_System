package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskPriority;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskRequest {
  @NotBlank(message = "Title is required")
  private String title;

  @Size(max = 100, message = ("Description is to big"))
  @NotBlank(message = "Description is required")
  private String description;

  @NotNull(message = "Status is required")
  private TaskStatus status;

  @NotNull(message = "Priority is required")
  private TaskPriority priority;

  private String comment;
}
