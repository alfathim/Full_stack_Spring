package cog.fse.task.respository;

import org.springframework.stereotype.Repository;

import cog.fse.task.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
