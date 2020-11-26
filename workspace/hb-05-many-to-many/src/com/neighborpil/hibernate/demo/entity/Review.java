package com.neighborpil.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {


	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// setup mapping to InstructorDetail entity
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="comment")
	private String comment;
	
	//private int courseId;
	
	public Review() {

	}

	public Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [Id=" + Id + ", comment=" + comment + "]";
	}
}
