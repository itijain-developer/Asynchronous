package bean;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//@XmlRootElement
public class People {
	
	@Size(min =3, max=20, message="my message") @NotNull @NotBlank
	private String name;
	@NotNull
	private Integer age;
	@NotNull
	private String address;
	
	public List<Map<String,String>> telNumbers;
	
	public List<Map<String, String>> getTelNumbers() {
		return telNumbers;
	}
	public void setTelNumbers(List<Map<String, String>> telNumbers) {
		this.telNumbers = telNumbers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
