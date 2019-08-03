package cog.fse.task.respository;

import cog.fse.task.model.ParentTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long>{

}
