package uk.co.biztraveller.munit.mocks.model;

/**
 * Mock Salesforce Lead Object
 * 
 * @author neildesouza
 * SOQL: SELECT City,Company,Email,FirstName,LastName,MobilePhone,Name,Phone,Title FROM Lead
 */

public class SalesforceLeadMock {
	
	private String firstName;
	private String lastName;
	private String mobilePhone;
	private String title;
	private String company;
	private String city;
	
	public SalesforceLeadMock (String variableNameSuffix) {
		this.firstName = "fName_" + variableNameSuffix;
		this.lastName = "lName_" + variableNameSuffix;
		this.mobilePhone = "0772828191";
		this.city="London";
		this.title = "Mr";
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
