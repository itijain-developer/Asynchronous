package temporary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.People;

public class TestCode {

	public static void main(String args[]) {
		
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
		
		People p1 = new People();
		p1.setName("Annie");
		p1.setAge(2);
		p1.setAddress("address");
		Map<String,String> m1= new LinkedHashMap <String,String>();
		m1.put("mobile","1234");
		m1.put("home", "5678");
		List<Map<String,String>> l1 = new ArrayList<Map<String,String>> ();
		l1.add(m1);
		p1.setTelNumbers(l1);
		
		People p2 = new People();
		p2.setName("Advit");
		p2.setAge(2);
		p2.setAddress("address");
		Map<String,String> m2= new LinkedHashMap <String,String>();
		m1.put("mobile","1234");
		m1.put("home", "5678");
		List<Map<String,String>> l2 = new ArrayList<Map<String,String>> ();
		l2.add(m2);
		p2.setTelNumbers(l2);
		
		List<People> persons = new ArrayList<People>();
		persons.add(p);
		persons.add(p1);
		persons.add(p2);
			   
		List<People> filtered =
			    persons
			        .stream()
			        .filter(person -> person.getAge() > 10)
			        .collect(Collectors.toList());
		
		System.out.println(filtered); 
		
		Integer ageSum = persons
			    .stream()
			    .reduce(0, (sum, person2) -> sum += person2.getAge(), (sum1, sum2) -> sum1 + sum2);

			System.out.println(ageSum); 
			persons.forEach(person -> System.out.println(person.getAge()));
			
			
	Map<Object, List<People>> personsByAge = persons
		    .stream()
		    .collect(Collectors.groupingBy(person1 -> person1.getAge()));

		personsByAge
		    .forEach((age, person1) -> System.out.format("age %s: %s\n", age, person1));

		// age 18: [Max]
		// age 23: [Peter, Pamela]
		// age 12: [David]
		
}
}
