package temporary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fabbonacci {

	
	public static void main(String args[]) {
	
	 Stream.iterate(new int[]{1, 1}, s -> new int[]{s[1], s[0] + s[1]})
     .limit(5)
     .map(n -> n[0])
     .forEach(System.out::println);

	 
	 String pal= "iitgtii";
	 boolean b= IntStream.range(0, pal.length()/2).allMatch(s -> (pal.charAt(s))==(pal.charAt(pal.length()-s-1)));
	 System.out.println("bool " + b);
	 
	 
	 
	 ArrayList<String> strings = new ArrayList<String>(Arrays.asList("I","am","iti","jain"));
	 String concatenated = strings.stream().reduce("", String::concat);
	 String concat = strings.stream().collect(StringBuilder::new,
             (sb, s1) -> sb.append(" ").append(s1),
             (sb1, sb2) -> sb1.append(sb2.toString())).toString();
	 
	 System.out.println(concatenated);

	 System.out.println(concat);
	}	
}
