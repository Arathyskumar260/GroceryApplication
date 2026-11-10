package utilities;

import com.github.javafaker.Faker;

public class Random_Data_Utility {
	Faker randomdt = new Faker();
	public String genrateRandomUsername() {
		return randomdt.name().username();//username are present in the  name method
	}
	public String genrateRandomPassword() {
		return randomdt.internet().password();//password are present in the internet method
	}
	public String genrateFullName() {
		return randomdt.name().fullName(); //fullname present in the name method
	}
	public String genrateEmail() {
		return randomdt.internet().emailAddress(); //email present in the internet method
	}
	public String genratePhone() {
		return randomdt.phoneNumber().cellPhone();//mobile phone present in the phonenumber method and in the cellphone method
	}

}
