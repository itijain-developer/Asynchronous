package temporary;

public class Example {

	public static void myMethod() {
		System.out.println("My method");
	}
	public static void main(String[] args) {
		MyFuncInt mi = Example::myMethod;
		mi.display();
		

	}

}
