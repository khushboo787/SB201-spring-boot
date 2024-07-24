package com.masaischool.B28_SB201_Ex_25_LOMBOK;

public class Employee {
	private Integer id;
	private String name;
	private double packageInLPA;
	private String state;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name, double packageInLPA, String state) {
		super();
		this.id = id;
		this.name = name;
		this.packageInLPA = packageInLPA;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPackageInLPA() {
		return packageInLPA;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPackageInLPA(double packageInLPA) {
		this.packageInLPA = packageInLPA;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", packageInLPA=" + packageInLPA + ", state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}