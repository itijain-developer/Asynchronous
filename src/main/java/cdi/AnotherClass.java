package cdi;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cdi.service.ImageFilter;
import cdi.service.ImageType;
import cdi.service.Mode;

public class AnotherClass {
	static Logger logger= LoggerFactory.getLogger(AnotherClass.class);
	//@Inject @ImageType(desiredMode = Mode.GIF)
	private ImageFilter imageFilter;

	@Inject
	AnotherClass(@ImageType(desiredMode = Mode.PNG) ImageFilter imageFilter){
		this.imageFilter=imageFilter;
		logger.info("Another class to string : "+ imageFilter.toString());
		
	}
	
	public void sayHello() {
		logger.info("Another class to string : "+ imageFilter.toString());
		logger.info("say hello called");

	}
}
