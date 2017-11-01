package model.actors;

public class Employee extends Person {

	private String type = null;

	public Employee() {

	}

	//get type attribute from Employee class
	public String getType() {
		return type;
	}
	
	//set type attribute from Employee class
	public void setType(String type) {
		this.type = type;
	}

}
