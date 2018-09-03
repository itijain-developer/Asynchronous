package people;

import java.util.Set;

import javax.validation.ConstraintViolation;

import bean.People;

public interface ValidatorInterface {

	
	public  Set<ConstraintViolation<People>> validate(People p) ;
	public  People getSampleBean();
	
}
