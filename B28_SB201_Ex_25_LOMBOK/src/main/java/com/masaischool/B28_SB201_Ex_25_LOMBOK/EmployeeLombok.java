//Detailed documentation is available here
//https://projectlombok.org/features/

package com.masaischool.B28_SB201_Ex_25_LOMBOK;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor@Getter
@Setter
@ToString
@EqualsAndHashCode

//We can use data annotation also @Data
public class EmployeeLombok {
	@ToString.Exclude private Integer id;
	@EqualsAndHashCode.Exclude private String name;
	@EqualsAndHashCode.Exclude private double packageInLPA;
	private String state;
	@EqualsAndHashCode.Exclude private List<String> hobbies;
	
	public EmployeeLombok(String name, double packageInLPA, String state, List<String> hobbies) {
		super();
		this.name = name;
		this.packageInLPA = packageInLPA;
		this.state = state;
		this.hobbies = hobbies;
	}
}
