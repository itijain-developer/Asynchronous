package cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import cdi.service.ImageFilter;
import cdi.service.PaymentFilter;
import cdi.service.ImageType;
import cdi.service.Mode;

@Decorator
abstract class ImageFilterDecorator implements ImageFilter{
	
	@Inject
	@Delegate
	@ImageType(desiredMode = Mode.PNG) ImageFilter imageFilter;
	
	@Inject 
	PaymentFilter paymentFilter;
	
	@Override
	public String openFile(String fileName) {
		String output = imageFilter.openFile(fileName);
		paymentFilter.getPayment();
		return output;
	}

}
