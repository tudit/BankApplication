function validate(){
	
	var Name = document.getElementById("accName").value;
	var dob = document.getElementById("dob").value;
	var phno = document.getElementById("phoneNo").value;
	var city = document.getElementById("city").value;
	var state = document.getElementById("state").value;
	var country = document.getElementById("country").value;
	var email = document.getElementById("email").value;
	var emailReg = /^[A-Za-z]+@[A-Za-z]+$/;
	//var emailReg = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	var dateReg = /^\d{4}[-]\d{2}[-]\d{2}$/;
	var nameReg =  /^[A-Za-z]+$/;
	var phnoReg = /^[1-9]{1}[0-9]*$/;
	var msg="";
	
	if(Name == null || Name == ""){
		msg = msg + "Name is mandotary" + "\n";
	}
	
	if(dob == null || dob == ""){
		msg = msg + "Date of Birth is mandotary" + "\n";
	}
	
	if(phno == null || phno == ""){
		msg = msg + "Phone no is mandotary" + "\n";
	}
	
	if(city == null || city == ""){
		msg = msg + "City is mandotary" + "\n";
	}
	
	if(state == null || state == ""){
		msg = msg + "State is mandotary" + "\n";
	}
	
	if(country == null || country == ""){
		msg = msg + "Country is mandotary" + "\n";
	}
	if(email == null || email == ""){
		msg = msg + "EmailId is mandotary" + "\n";
	}
		
	if(Name != null && Name != ""){
		if(Name.length < 10){
			msg = msg + "Name must be minimum of 10 characters" + "\n";
		}
	
		if(!Name.match(nameReg)){
			msg = msg + "Name must contain alphabets only" + "\n";
		}
	}
	
	if(dob != null && dob != ""){
		if(!dob.match(dateReg)){
			msg = msg + "Date must follow the pattern yyyy-mm-dd" + "\n";
		}
	}
	
	if(phno != null && phno != ""){
		if(phno.length != 10){
			msg = msg + "Phone number must be of 10 digits" + "\n";
		}
	
		if(!phno.match(phnoReg)){
			msg = msg + "Phone number must not start with a 0" + "\n";
		}
	}
	
	if(city != null && city != "") {
		if(!city.match(nameReg)){
			msg = msg + "City must contain alphabets only" + "\n";
		}
	}
	
	if(state != null && state != ""){
		if(!state.match(nameReg)){
			msg = msg + "State must contain alphabets only" + "\n";
		}
	}
	
	if(country != null && country != ""){
		if(!country.match(nameReg)){
			msg = msg + "Country must contain alphabets only" + "\n";
		}
	}
	
	if(email != null && email != ""){
		if(!email.match(emailReg)){
			msg = msg + "Not a valid email" + "\n";
		}
	}
	
	if(msg == ""){
		alert("Success!!");
		return true;
	}
	else{
		document.getElementById("errorLog").innerHTML = msg;
		alert(msg);
	return false;
	}
}

function errorclear(){
	var msg="";
	document.getElementById("errorLog").innerHTML = msg;
}