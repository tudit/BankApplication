package mvc;

public class Account {
	
	private String accNo;
	private String accName;
	private String dob;
	private String phoneNo;
	private String gender;
	private String city;
	private String state;
	private String country;
	private String houseNo;
	private String street;
	private String email;
	
	public Account(){}
		
	
	
/*	
	public void credit(float credit){
		if(credit>=100)
		bal+=credit;
		else
			System.out.println("Credit cannot be less than 100");
	}
	
	public void debit(float debit)throws WithdrawalException{
		if(bal-debit<1000)
			throw new WithdrawalException();
		else
			bal-=debit;
	}
	
	//for testing
	public void printDetails(){
		System.out.println("Account Number: "+acc);
		System.out.println("Name of the Account Holder: "+name);
		System.out.println("Account Balance : "+bal);
		System.out.println("----------------------------------------------------------\n\n");
	}
*/
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
