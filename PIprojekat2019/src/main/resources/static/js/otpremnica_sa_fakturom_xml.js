$(document).ready(function(){
	
	$('#xmlOtpremnicaSubmit').on('click', function(event){
		
		$.get("http://localhost:8080/api/otpremnice/generateOtpremniceSaFakturom/", function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('XML otpremnice sa fakturama generisane.')
			
			window.location.href = "otpremnica_sa_fakturom.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});