package ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.entity.Task;
import ru.chernenkiy.java_tz_skypro_effective_mobile_task_management_system.repository.TaskRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;



    @Test
    void testGetTasks() {
        // Arrange
        Task task1 = new Task();
        Task task2 = new Task();
        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getTasks();

        assertEquals(tasks, result);
        verify(taskRepository, times(1)).findAll();
    }
}
