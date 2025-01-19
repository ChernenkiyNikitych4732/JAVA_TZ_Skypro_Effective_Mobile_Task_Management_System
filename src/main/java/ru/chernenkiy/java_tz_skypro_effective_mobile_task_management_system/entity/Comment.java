package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

  private String text;

  private String author;

  private LocalDateTime timestamp;
}
