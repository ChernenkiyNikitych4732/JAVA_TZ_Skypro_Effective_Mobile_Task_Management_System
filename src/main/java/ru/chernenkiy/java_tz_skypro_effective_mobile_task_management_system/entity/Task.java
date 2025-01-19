package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.entity;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskPriority;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "task")
  private String title;

  private String description;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "task_comments", joinColumns = @JoinColumn(name = "task_id"))
  private List<Comment> comments = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @Enumerated(EnumType.STRING)
  private TaskPriority priority;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id")
  private User author;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "performer_id")
  private User performer;
}
