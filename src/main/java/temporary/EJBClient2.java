package temporary;

import javax.ejb.EJB;

public class EJBClient2 {

	 @EJB
	    public StatelessEJB statelessEJB;
	 
	 public StatelessEJB getStatelessEJB() {
			return statelessEJB;
		}

		public void setStatelessEJB(StatelessEJB statelessEJB) {
			this.statelessEJB = statelessEJB;
		}
	 
}
