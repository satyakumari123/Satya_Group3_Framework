package com.training.bean;

public class AddaUserBean {
	private String FirstName,LastName,eMail,UserName,Pass,ConfirmPass,Phone,Language;
	public AddaUserBean() {
	}
	public AddaUserBean(String FirstName, String LastName,String eMail,String Phone,String UserName,String Pass) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.eMail = eMail;
		this.Phone = Phone;
		this.UserName=UserName;
		this.Pass = Pass;
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
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
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
	@Override
	public String toString() {
		return "RegistrationBean [FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + eMail +", Phone=" + Phone +", UserName=" + UserName +", Password=" + Pass +"]";
	}
	

}
