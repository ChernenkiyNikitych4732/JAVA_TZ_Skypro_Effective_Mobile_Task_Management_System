package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.service;

import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.repository.TaskRepository;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
  private final TaskRepository taskRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> getTasks() {
    return taskRepository.findAll();
  }
}
