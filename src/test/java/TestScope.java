import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import requestScope.Waiter;

public class TestScope {
	Waiter joe;
	
	@Before
	public void setup() {
	 joe= new Waiter();
	}
	
	@Test
	public void orderSoup() {
		String test= joe.orderSoup("Manchow");
		assertEquals("Manchow", test);
		
	}

}
