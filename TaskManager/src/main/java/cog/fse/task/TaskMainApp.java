package cog.fse.task;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import cog.fse.task.model.ParentTask;
import cog.fse.task.model.Task;
import cog.fse.task.respository.ParentTaskRepository;
import cog.fse.task.service.TaskServiceImpl;

@SpringBootApplication
//public class TaskMainApp implements CommandLineRunner {
public class TaskMainApp extends SpringBootServletInitializer{ 

	public static void main(String[] args) {
		SpringApplication.run(TaskMainApp.class, args);
	}

	@Autowired
	private TaskServiceImpl taskService;

	@Autowired
	private ParentTaskRepository parentRepo;

	// @Override
	public void run(String... args) throws Exception {

		ParentTask p = new ParentTask();
		p.setParentTaskName("parent3");

		/// parentRepo.save(p);

		
		  Task t =new Task(); 
		  t.setName("task3"); 
		  t.setStartDate(new Date());
		  t.setEndDate(new Date());
		  t.setPriority(1); 
		  t.setParentTask(p); 
		  p.setTask(t);
		  
		  parentRepo.save(p);
		  
		  //taskService.saveTask(t);
		 
		// parentRepo.deleteById(1l);

		List<Task> taskList = taskService.getAllTask();

		for (Task task : taskList) {
			// System.out.println( task.getParentTask().getParentTaskName() );
			// System.out.println( task.getParentTask().getId() );
			System.out.println(task.getId());
			System.out.println(task.getName());
			System.out.println(task.getParentTask().getId());
			System.out.println(task.getParentTask().getParentTaskName());
		}
		// System.out.println(taskService.getAllTask());

	}

}
