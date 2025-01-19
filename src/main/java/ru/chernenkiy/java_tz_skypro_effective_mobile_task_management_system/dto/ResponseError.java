package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Data
public class ResponseError {
  private final HttpStatus status;
  private final String message;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private final LocalDateTime time = LocalDateTime.now();
}
