$(document).ready(function() {
	
	var stavka = []
	
	var redni_broj_proizvodaInput = $('#redni_broj_proizvodaInput');
	
	var redni_broj_proizvodaCell = $('#redni_broj_proizvodaCell');
	var jedinica_mereCell = $('#jedinica_mereCell');
	var cenaCell = $('#cenaCell');
	var kolicinaCell = $('#kolicinaCell');
	var napomenaCell = $('#napomenaCell');

   
 	$('#stavkaSubmit').on('click', function(event){
		var redni_broj_proizvoda = redni_broj_proizvodaInput.val();

		console.log('redni_broj_proizvoda: ' + redni_broj_proizvoda);
		
		var params = {
			'redni_broj_proizvoda': redni_broj_proizvoda
		}
		$.post("http://localhost:8080/api/stavkeotpremnice/pojedinacnaStavkaOtpremnice", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji stavke otpremnice...')
			
			stavka = data;
			
			$('#redni_broj_proizvodaCell').val(stavka.redniBrojProizvoda);
			$('#jedinica_mereCell').val(stavka.jedinicaMere);
			$('#cenaCell').val(stavka.cena);
			$('#kolicinaCell').val(stavka.kolicina);
			$('#napomenaCell').val(stavka.napomena);
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});