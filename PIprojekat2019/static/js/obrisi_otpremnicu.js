$(document).ready(function(){
	var broj_otpremniceInput = $('#broj_otpremniceInput');

	
	$('#otpremnicaSubmit').on('click', function(event){
		var broj_otpremnice = broj_otpremniceInput.val();
		
		console.log('broj_otpremnice: ' + broj_otpremnice);
		
		var params = {
			'broj_otpremnice': broj_otpremnice
		}
		$.post("http://localhost:8080/api/otpremnice/obrisiOtpremnicu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je otpremnica.');
			
			window.location.href = "otpremnice.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});