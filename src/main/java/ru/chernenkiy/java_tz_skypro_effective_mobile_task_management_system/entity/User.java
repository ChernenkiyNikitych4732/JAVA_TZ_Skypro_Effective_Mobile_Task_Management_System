package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.RoleList;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  private String email;

  @JsonIgnore private String password;

  @Enumerated(EnumType.STRING)
  private RoleList role;

  @OneToMany(
      mappedBy = "author",
      fetch = FetchType.EAGER,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JsonIgnore
  private List<Task> tasks;
}
