package temporary;

import javax.ejb.Stateless;

@Stateless
public class StatelessEJB {
 
    public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
}