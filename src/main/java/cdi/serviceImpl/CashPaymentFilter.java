package cdi.serviceImpl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cdi.service.PaymentFilter;
import cdi.service.AuthCustomer;
import cdi.service.Log;
import people.Server;

@Log
public class CashPaymentFilter implements PaymentFilter {
	static Logger logger = LoggerFactory.getLogger(Server.class);
	
	@Inject 
	public AuthCustomer auth;
	
	@Override
	public void getPayment() {
		logger.info(auth.auth());
		logger.info("Processing Cash");
		
	}

}
