package cog.fsd.java.assgn2.dto;

// default package
// Generated Jun 29, 2019, 10:55:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cog_book")
public class Book implements java.io.Serializable { 

	
	 @Id
	 @Column(name="Id")
	 //@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 
	//private Subject cogSubject;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="volume")
	private Integer volume;
	
	@Column(name="publishdate")
	private Date publishDate;

	public Book() {
	}

	public Book(int id) {
		this.id = id;
	}

	public Book(int id, Subject cogSubject, String title, Double price, Integer volume, Date publishDate) {
		this.id = id;
		//this.cogSubject = cogSubject;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	} 

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public Subject getCogSubject() { return this.cogSubject; }
	 * 
	 * public void setCogSubject(Subject cogSubject) { this.cogSubject = cogSubject;
	 * }
	 */

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getVolume() {
		return this.volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
		.append("id:").append(id).append(",")
		.append("title:").append(title)
		.append(";").append("Date:").append(publishDate);
		return sb.toString();
		
	}
	
	/**<class name="cog.fsd.java.assgn2.dto.Book" table="cog_book" catalog="world">
    <id name="id" type="int">
        <column name="Id" />
        <generator class="assigned" />
    </id>
    <many-to-one name="cogSubject" class="cog.fsd.java.assgn2.dto.Subject" fetch="select">
        <column name="subjectId" />
    </many-to-one>
    <property name="title" type="string">
        <column name="title" />
    </property>
    <property name="price" type="java.lang.Double">
        <column name="price" precision="22" scale="0" />
    </property>
    <property name="volume" type="java.lang.Integer">
        <column name="volume" />
    </property>
    <property name="publishDate" type="date">
        <column name="publishDate" length="10" />
    </property>
</class> */

}
