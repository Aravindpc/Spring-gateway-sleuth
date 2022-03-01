package com.crudexample.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persondto {

	private long id;
	
	private String first_name;

	private String last_name;

	private String ssn;

	private String title;

    private LocalDateTime dob;
	
    private Bankdto bank;
    
    private Long bank_id;

	@Override
	public String toString() {
		return "Persondto [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", ssn=" + ssn
				+ ", title=" + title + ", dob=" + dob + ", bank=" + bank + ", bank_id=" + bank_id + "]";
	}

}
