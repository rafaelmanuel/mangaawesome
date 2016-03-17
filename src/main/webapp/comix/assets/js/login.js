
var xmlHttp = createXMLHttpRequest();

function createXMLHttpRequest(){
	if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return new ActiveXObject("Microsoft.XMLHTTP")
	}
}

function process(){

	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	
	xmlHttp.onreadystatechange = function(){
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			
		     if(xmlHttp.responseText.replace("\n" , "") == "valid"){
		    	 window.location.href = "/mangaawesome/comix/authenticate.jsp";
		     }else{
		    	 var message = document.getElementById("message");
		    	 message.innerHTML = "Invalid email or password";
		    	 message.style.color = "red";
		     }
		}
	}

	xmlHttp.open("POST", "/mangaawesome/login", true);
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//multipart/form-data
	xmlHttp.send("email="+ email +"&password=" + password);
}

document.getElementById("submit").addEventListener("click", process);