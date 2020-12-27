$(document).ready(function(){
	var redni_broj_proizvodaInput = $('#redni_broj_proizvodaInput');

	
	$('#stavkaSubmit').on('click', function(event){
		var redni_broj_proizvoda = redni_broj_proizvodaInput.val();
		
		console.log('redni_broj_proizvoda: ' + redni_broj_proizvoda);
		
		var params = {
			'redni_broj_proizvoda': redni_broj_proizvoda
		}
		$.post("http://localhost:8080/api/stavkeotpremnice/obrisiStavkuOtpremnice", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je stavka otpremnice')
			
			window.location.href = "stavke_otpremnice.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});