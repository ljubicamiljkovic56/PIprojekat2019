$(document).ready(function(){
	var usernameInput = $('#usernameInput');
	var passwordInput = $('#passwordInput');
	var repeatedPasswordInput = $('#repeatedPasswordInput');

	
	$('#registerSubmit').on('click', function(event){
		var username = usernameInput.val();
		var password = passwordInput.val();
		var repeatedPassword = repeatedPasswordInput.val();
		console.log('username: ' + username);
		console.log('password: ' + password);
		console.log('repeatedPassword: ' + repeatedPassword);
		
		if(password != repeatedPassword) {
			alert('Lozinke nisu iste!');
			
			event.preventDefault();
			return false;
		}
		var params = {
			'username': username, 
			'password': password
		}
		$.post("http://localhost:8080/api/korisnici/korisnik/registracija", params, function(data){
			console.log(data);
			console.log(username);
			console.log(password);
			
			alert('Uspesna registracija');
			
			
			window.location.replace('login.html');
			
		});
		event.preventDefault();
		return false;
	});
});