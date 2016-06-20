package xmlrpcserver1;

public class Parameter {
	public String name;
	public String description;
	
	public Parameter(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return  name + " - " + description;
	}
}
