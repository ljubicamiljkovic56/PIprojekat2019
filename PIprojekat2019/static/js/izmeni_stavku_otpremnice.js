$(document).ready(function(){
	
	var redni_broj_proizvodaInput = $('#redni_broj_proizvodaInput');
	var novi_brojInput = $('#novi_brojInput');
	var jedinica_mereInput = $('#jedinica_mereInput');
	var cenaInput = $('#cenaInput');
	var kolicinaInput = $('#kolicinaInput');
	var napomenaInput = $('#napomenaInput');

	$('#stavkaSubmit').on('click', function(event){
		var redni_broj_proizvoda = redni_broj_proizvodaInput.val();
		var novi_broj = novi_brojInput.val();
		var jedinica_mere = jedinica_mereInput.val();
		var cena = cenaInput.val();
		var kolicina = kolicinaInput.val();
		var napomena = napomenaInput.val();
		
		console.log('redni_broj_proizvoda: ' + redni_broj_proizvoda);
		console.log('novi_broj: ' + novi_broj);
		console.log('jedinica_mere: ' + jedinica_mere);
		console.log('cena: ' + cena);
		console.log('kolicina: ' + kolicina);
		console.log('napomena: ' + napomena);
		
		var params = {
			'redni_broj_proizvoda': redni_broj_proizvoda,
			'novi_broj': novi_broj,
			'jedinica_mere': jedinica_mere,
			'cena': cena,
			'kolicina': kolicina,
			'napomena': napomena
		}
		$.post("http://localhost:8080/api/stavkeotpremnice/izmeniStavkuOtpremnice/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena stavke otpremnice')
			
			window.location.href = "stavke_otpremnice.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});