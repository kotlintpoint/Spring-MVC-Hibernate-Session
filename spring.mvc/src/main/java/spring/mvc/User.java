package spring.mvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotEmpty(message = "Name is Required!!!")
	@Size(min = 3, max = 10, message = "Min 3 and Max 10 characters Required")
	private String name;
	
	//@NotEmpty(message="Age is Required")
	@Range(min = 1, max=100, message = "Enter Age between 1 and 100")
	@NotNull(message="Age is Required")
	private Integer age;
	
	@NotEmpty(message="Email Required")
	@Email(message = "Enter Valid Email...")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
