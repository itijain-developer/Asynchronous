package requestScope;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Waiter {
	
	@Inject
	private Soup soup;
	
	@EJB
	private Chef chef;
	
	public String orderSoup(String name) {
		soup.setName(name);
		return chef.prepareSoup().getName();
	}

}
