package types;

public class Car implements Comparable<Car> {
	
	public Car(String model, Integer year) {
		this.model = model;
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Override
	public int compareTo(Car o) {
		return year.compareTo(o.getYear());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null) {
			return o.equals(model + ", " + year);
		} else {
			return false;
		}
	}
	
	private String model;
	private Integer year;
}
