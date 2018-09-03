package requestScope;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Soup {
	
	private String name="Soup of Day";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@PostConstruct
    //public void afterCreate() {
    //    System.out.println("Soup created");
    //}

}
