package xmlrpcserver1;

import java.util.LinkedList;
import java.util.List;

public class Service {
	public String name;
	public String description;
	public final List<Parameter> parameters;
	
	public Service(String name, String description) {
		this.name = name;
		this.description = description;
		this.parameters = new LinkedList<Parameter>();
	}

	@Override
	public String toString() {
		String result = String.format("%s - %s \n", name, description);
		
		if(!parameters.isEmpty())
			result += String.format(" Parametry: \n");
		
		for(Parameter parameter: parameters)
			result += String.format("  %s \n", parameter);
		
		return result;
	}
}
