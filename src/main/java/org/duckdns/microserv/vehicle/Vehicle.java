package org.duckdns.microserv.vehicle;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.duckdns.microserv.person.Person;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
	private String regnumber;
	
	private String brand;
	
	private String model;
	
	private int modelyear;
	
	private String type;
	
	@ManyToOne
	private Person owner;
	
	

	public Vehicle() {
		super();
	}






	public Vehicle(String regnumber, String brand, String model, int modelyear, String type, int owner_id) {
		super();
		this.regnumber = regnumber;
		this.brand = brand;
		this.model = model;
		this.modelyear = modelyear;
		this.type = type;
		this.owner = new Person(owner_id);
	}
	
	public Vehicle(String regnumber, String brand, String model, int modelyear, String type, String owner_id) {
		super();
		this.regnumber = regnumber;
		this.brand = brand;
		this.model = model;
		this.modelyear = modelyear;
		this.type = type;
		this.owner = new Person(Integer.parseInt(owner_id));
	}

	
	
	
	
	
	public String getRegnumber() {
		return regnumber;
	}

	public void setRegnumber(String regnumber) {
		this.regnumber = regnumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getModelyear() {
		return modelyear;
	}

	public void setModelyear(int modelyear) {
		this.modelyear = modelyear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Vehicle [regnumber=" + regnumber + ", brand=" + brand + ", model=" + model + ", modelyear=" + modelyear
				+ ", type=" + type + ", owner=" + owner + "]";
	}
	
	
	

	

}
