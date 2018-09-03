import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import temporary.EJBClient1;
import temporary.EJBClient2;
import temporary.StatelessEJB;

public class StatefulEJBTest {
	
    private EJBClient1 ejbClient1 = new EJBClient1() ;
 
    @Inject
    private EJBClient2 ejbClient2 = new EJBClient2();
 
    @Test
    public void givenOneStatelessBean_whenStateIsSetInOneBean_secondBeanShouldHaveSameState() {
 
    	StatelessEJB s =new StatelessEJB();
    	s.setName("C1");
        ejbClient1.setStatelessEJB(s);
        assertEquals("C1", ejbClient1.statelessEJB.name);
        assertEquals("C1", ejbClient2.statelessEJB.name);
    }
 
    @Test
    public void givenOneStatelessBean_whenStateIsSetInBothBeans_secondBeanShouldHaveSecondBeanState() {
 
        ejbClient1.statelessEJB.name = "Client 1";
        ejbClient2.statelessEJB.name = "Client 2";
        assertEquals("Client 2", ejbClient2.statelessEJB.name);
    }
 
}
