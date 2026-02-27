package sn.isi.l3gl.api.task_api.controller;

import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.task_core.entity.Status;
import sn.isi.l3gl.core.task_core.entity.Task;
import sn.isi.l3gl.core.task_core.service.TaskService;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Créer une tâche
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Lister toutes les tâches
    @GetMapping
    public List<Task> listTasks() {
        return taskService.listTasks();
    }

    // Mettre à jour le status d'une tâche
    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return taskService.updateStatus(id, status);
    }

    // Compter les tâches terminées
    @GetMapping("/done/count")
    public long countCompletedTasks() {
        return taskService.countCompletedTasks();
    }
}