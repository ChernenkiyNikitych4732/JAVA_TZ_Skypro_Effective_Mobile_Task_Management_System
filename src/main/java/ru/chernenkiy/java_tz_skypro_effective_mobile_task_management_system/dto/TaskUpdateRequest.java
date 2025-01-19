package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskPriority;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskUpdateRequest {
  private String title;

  @Size(max = 100, message = ("Description is to big"))
  private String description;

  private TaskStatus status;

  private TaskPriority priority;
}
