package cog.fse.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cog.fse.task.model.Task;
import cog.fse.task.service.TaskServiceImpl;

@RestController
public class TaskController {

	@Autowired
	private TaskServiceImpl taskService;
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Task> getAllTask() {
		return taskService.getAllTask();
	}
	
	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Task getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id);
	}
	
	
	@RequestMapping(value = "/addTask", method = RequestMethod.POST, headers = "Accept=application/json")
	public void saveTask(@RequestBody Task task) {
		taskService.saveTask(task);
	}
 
	
 
	@RequestMapping(value = "/updateTask", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateTask(@RequestBody Task task)  {
		taskService.saveTask(task);
 
	}
	
	@RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteTask(@PathVariable("id") Long id)  {
		taskService.deleteTask(id);
 
	}
 
	
	
}
