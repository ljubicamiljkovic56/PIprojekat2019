$(document).ready(function(){	
	var fakturaInput = $('#fakturaInput');
	var redni_broj_proizvodaInput = $('#redni_broj_proizvodaInput');
	var kupacInput = $('#kupacInput');
	var adresa_isporukeInput = $('#adresa_isporukeInput');
	var datum_isporukeInput = $('#datum_isporukeInput');
	var prevoznikInput = $('#prevoznikInput');

	
	$('#otpremnicaSubmit').on('click', function(event){
		var faktura = fakturaInput.val();
		var redni_broj_proizvoda = redni_broj_proizvodaInput.val();
		var kupac = kupacInput.val();
		var adresa_isporuke = adresa_isporukeInput.val();
		var datum_isporuke = datum_isporukeInput.val();
		var prevoznik = prevoznikInput.val();
	
		console.log('faktura: ' + faktura);
		console.log('redni_broj_proizvoda: ' + redni_broj_proizvoda);
		console.log('kupac: ' + kupac);
		console.log('adresa_isporuke: ' + adresa_isporuke);
		console.log('datum_isporuke: ' + datum_isporuke);
		console.log('prevoznik: ' + prevoznik);
	
		
		var params = {
			'faktura': faktura,
			'redni_broj_proizvoda': redni_broj_proizvoda,
			'kupac': kupac,
			'adresa_isporuke': adresa_isporuke,
			'datum_isporuke': datum_isporuke,
			'prevoznik': prevoznik
			

		}
		$.post("http://localhost:8080/api/otpremnice/dodajOtpremnicuSaFakturom", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova otpremnica sa fakturom.')
			
			window.location.href = "otpremnica_sa_fakturom.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});