package model.actors;


public class Pet {

	private String clientID = null;
	private String name = null;
	private String type = null;
	private String breed = null;
	private String collor = null;
	private String gender = null;

	public Pet() {

	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getCollor() {
		return collor;
	}

	public void setCollor(String collor) {
		this.collor = collor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
