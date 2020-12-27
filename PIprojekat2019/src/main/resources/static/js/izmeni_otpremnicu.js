$(document).ready(function(){
	
	var broj_otpremniceInput = $('#broj_otpremniceInput');
	var novi_brojInput = $('#novi_brojInput');
	var kupacInput = $('#kupacInput');
	var adresa_isporukeInput = $('#adresa_isporukeInput');
	var datum_isporukeInput = $('#datum_isporukeInput');
	var prevoznikInput = $('#prevoznikInput');
	var fakturaInput = $('#fakturaInput');
	var redni_broj_proizvodaInput = $('#redni_broj_proizvodaInput');
	

	$('#otpremnicaSubmit').on('click', function(event){
		var broj_otpremnice = broj_otpremniceInput.val();
		var novi_broj = novi_brojInput.val();
		var kupac = kupacInput.val();
		var adresa_isporuke = adresa_isporukeInput.val();
		var datum_isporuke = datum_isporukeInput.val();
		var prevoznik = prevoznikInput.val();
		var faktura = fakturaInput.val();
		var redni_broj_proizvoda = redni_broj_proizvodaInput.val();
		
		console.log('broj_otpremnice: ' + broj_otpremnice)
		console.log('novi_broj: ' + novi_broj);
		console.log('kupac: ' + kupac);
		console.log('adresa_isporuke: ' + adresa_isporuke);
		console.log('datum_isporuke: ' + datum_isporuke);
		console.log('prevoznik: ' + prevoznik);
		console.log('faktura: ' + faktura);
		console.log('redni_broj_proizvoda: ' + redni_broj_proizvoda);
		
		var params = {
			'broj_otpremnice': broj_otpremnice,
			'novi_broj': novi_broj,
			'kupac': kupac,
			'adresa_isporuke': adresa_isporuke,
			'datum_isporuke': datum_isporuke,
			'prevoznik': prevoznik,
			'faktura': faktura,
			'redni_broj_proizvoda': redni_broj_proizvoda
		}
		$.post("http://localhost:8080/api/otpremnice/izmeniOtpremnicu/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena otpremnice')
			
			window.location.href = "otpremnice.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});