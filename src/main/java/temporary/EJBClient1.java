package temporary;

import javax.ejb.EJB;

public class EJBClient1 {

	@EJB
    public StatelessEJB statelessEJB;
	public Object statefulEJB;

	public StatelessEJB getStatelessEJB() {
		return statelessEJB;
	}

	public void setStatelessEJB(StatelessEJB statelessEJB) {
		this.statelessEJB = statelessEJB;
	}
 
	
}
