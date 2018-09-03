package people;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.People;


public class ValidatorClass implements ValidatorInterface{
	static Logger logger = LoggerFactory.getLogger(ValidatorClass.class);

	public  Set<ConstraintViolation<People>> validate(People p){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<People>> violations = validator.validate(p);
		return violations;

	}

	public  People getSampleBean() {

		People p = new People();
		p.setName("iti");
		p.setAge(23);
		p.setAddress("address");
		Map<String,String> m= new LinkedHashMap <String,String>();
		m.put("mobile","1234");
		m.put("home", "5678");
		List<Map<String,String>> l = new ArrayList<Map<String,String>> ();
		l.add(m);
		p.setTelNumbers(l);
		return p;

	}
	
	public static Set<ConstraintViolation<People>> validateStatic(People p){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<People>> violations = validator.validate(p);
		return violations;

	}

	public static People getStaticSampleBean() {

		People p = new People();
		p.setName("iti");
		p.setAge(23);
		p.setAddress("address");
		Map<String,String> m= new LinkedHashMap <String,String>();
		m.put("mobile","1234");
		m.put("home", "5678");
		List<Map<String,String>> l = new ArrayList<Map<String,String>> ();
		l.add(m);
		p.setTelNumbers(l);
		return p;

	}

	public static People getSampleExpensiveBean() {

		People p = new People();
		p.setName("it");
		p.setAge(23);
		p.setAddress("address");
		Map<String,String> m= new LinkedHashMap <String,String>();
		m.put("mobile","1234");
		m.put("home", "5678");
		List<Map<String,String>> l = new ArrayList<Map<String,String>> ();
		l.add(m);
		p.setTelNumbers(l);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}
	
}
