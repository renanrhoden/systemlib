package user;

public class User {
	private String name;
	private int age;
	private String id;
	
	public User(String name, int age, String id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}
	
	
	
}
