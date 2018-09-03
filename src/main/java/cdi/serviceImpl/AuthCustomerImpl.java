package cdi.serviceImpl;

import cdi.service.AuthCustomer;

public class AuthCustomerImpl implements AuthCustomer{

	@Override
	public String auth() {
		return "Customer in autheticated";
	}
	
	

}
