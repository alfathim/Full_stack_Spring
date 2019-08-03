package cog.fse.task.model; 

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * Task -Table 
 * 	Id
 * 	Parent _ID
 * 	Task_name
 * 	Start_Date
 * 	End_Date
 * 	Priority
*
 */

@Entity
@Table(name = "task")
public class Task implements Serializable { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")   
    private String name; 

  
    @Column(name = "Start_Date")
    private Date startDate;
    
    @Column(name = "end_Date")
    private Date endDate;    

    
    @Column(name = "priority")
    private int priority;

   

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", nullable = true)
   
    private ParentTask parentTask;
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    

    public Task() {

    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getStartDate() {
		try {
			return sdf.parse(sdf.format(startDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		
		try {
			return sdf.parse(sdf.format(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endDate;
		
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	


	public ParentTask getParentTask() {
		return parentTask;
	}



	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}



	public int getPriority() {
		return priority;
	}



	public void setPriority(int priority) {
		this.priority = priority;
	}

   
}
