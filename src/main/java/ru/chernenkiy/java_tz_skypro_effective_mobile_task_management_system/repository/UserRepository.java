package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.repository;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.enums.RoleList;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByIdAndRole(Long userId, RoleList role);

  @Query("SELECT u FROM User u LEFT JOIN FETCH u.tasks WHERE u.role = :role")
  @EntityGraph(attributePaths = {"tasks"})
  List<User> findAllWithTasksByRole(@Param("role") RoleList role);

  Optional<User> findUserById(Long userId);

  Optional<User> findUserByUsername(String username);

  Optional<User> findUsersByEmail(String email);

  Boolean existsUserByUsername(String username);

  Boolean existsUserByEmail(String email);
}
