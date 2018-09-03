package requestScope;

import javax.inject.Inject;

public class Chef {

	@Inject
	private Soup soup;
	
	public Soup prepareSoup() {
		System.out.println("Soup prepared " + soup.getName() );
		return soup;
	}
}
