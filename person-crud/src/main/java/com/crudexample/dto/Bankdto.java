package com.crudexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bankdto {
	
	private String bank_reg_number;
	
	private String bank_identification_code;

	private String bank_name;
	
	private String country;
	
	private String registered_address;

	@Override
	public String toString() {
		return "Bankdto [bank_reg_number=" + bank_reg_number + ", bank_identification_code=" + bank_identification_code
				+ ", bank_name=" + bank_name + ", country=" + country + ", registered_address=" + registered_address
				+ "]";
	}


}
