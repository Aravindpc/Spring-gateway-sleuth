package com.crudexample.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="persons")
public class Person {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private long id;
	
	@Column(name="first_name", nullable = false)
	private String first_name;

	@Column(name="last_name", nullable = false)
	private String last_name;
	
	@Column(name="ssn", nullable = false)
	private String ssn;
	
	@Column(name="title", nullable = false)
	private String title;

	@Column(name="bank_id",nullable=true)
	private long bank_id;
	
	@Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dob;

	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", ssn=" + ssn
				+ ", title=" + title + ", bank_id=" + bank_id + ", dob=" + dob + "]";
	}
	
}
