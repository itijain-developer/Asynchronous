package cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cdi.service.ImageFilter;
import cdi.service.ImageType;
import cdi.service.Log;
import cdi.service.Mode;

@Log @Interceptor
public class LoggerInterceptor {
	static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	//@Inject
	//@ImageType(desiredMode = Mode.PNG) ImageFilter imageFilter;

	
	@AroundInvoke
	public Object logClass(InvocationContext ctx) throws Exception {
	//	imageFilter.toString();
		logger.info("In class : " + ctx.getTarget().getClass() );
		logger.info("Start of method : " + ctx.getMethod().getName());
		return ctx.proceed();
	}

}
