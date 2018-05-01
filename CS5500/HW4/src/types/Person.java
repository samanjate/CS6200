package types;

public class Person implements Comparable<Person> {

	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Person person) {
		return name.compareTo(person.getName());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null) {
			return o.equals(name);
		} else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private String name;

}
