package cog.fse.task.service;

import java.util.List;

import org.hibernate.internal.CoreLogging;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cog.fse.task.model.ParentTask;
import cog.fse.task.model.Task;
import cog.fse.task.respository.ParentTaskRepository;
import cog.fse.task.respository.TaskRepository;

@Service
public class TaskServiceImpl {
	
	private static final Logger log = CoreLogging.logger( TaskServiceImpl.class );
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ParentTaskRepository parentTaskRepo;
	
	/**
	 * get all the task 
	 * @return
	 */
	public List<Task> getAllTask() {
		return taskRepo.findAll();
	}
	
	/**
	 * get Task by Id 
	 * @param id
	 * @return
	 */
	public Task getTaskById(Long id ) {
		return taskRepo.getOne(id);
	}
	
	
	/**
	 * Save the task 
	 * @param task
	 * @return
	 */
	public Task saveTask(Task task ) {
		
		ParentTask parentTask = task.getParentTask();
		if(parentTask!=null &&  ! StringUtils.isEmpty(parentTask.getParentTaskName())) {
			parentTaskRepo.save(parentTask);
		}
		
		return taskRepo.save(task);
	}
	
	/**
	 * delete the task 
	 * @param id
	 */
	public void deleteTask(Long id ) {
		log.debug("====deleting ...."+id);	
		parentTaskRepo.deleteById(id);
		//taskRepo.deleteById(id);
	}
	
	
	

}
