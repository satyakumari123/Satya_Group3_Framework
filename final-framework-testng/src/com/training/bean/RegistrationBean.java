package com.training.bean;
/**
 * 
 * @author satya
 * @see this class shall get the bean data 
 */

public class RegistrationBean {
	private String FirstName,LastName,eMail,UserName,Pass,ConfirmPass,Phone,Language;
	public RegistrationBean() {
	}
	public RegistrationBean(String FirstName, String LastName,String eMail,String UserName,String Pass,String ConfirmPass, String Phone,String Language) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.eMail = eMail;
		this.UserName=UserName;
		this.Pass = Pass;
		this.ConfirmPass = ConfirmPass;
		this.Phone = Phone;
		this.Language = Language;
	}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}
	
	public String getConfirmPass() {
		return ConfirmPass;
	}

	public void setConfirmPass(String ConfirmPass) {
		this.ConfirmPass = ConfirmPass;
	}
	
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String Language) {
		this.Language = Language;
	}
	@Override
	public String toString() {
		return "RegistrationBean [FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + eMail +", UserName=" + UserName +", Password=" + Pass +", ConfirmPassword=" + ConfirmPass +", Phone=" + Phone +", Language=" + Language +"]";
	}
	
}
