package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
  @Size(max = 100, message = ("Comment is to big"))
  @NotBlank(message = "Comment is required")
  private String comment;
}
