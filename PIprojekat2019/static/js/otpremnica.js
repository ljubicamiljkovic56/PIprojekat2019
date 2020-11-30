$(document).ready(function() {
	
	var otpremnica = []
	
	var broj_otpremniceInput = $('#broj_otpremniceInput');
	
	var broj_otpremniceCell = $('#broj_otpremniceCell');
	var kupacCell = $('#kupacCell');
	var adresa_isporukeCell = $('#adresa_isporukeCell');
	var datum_isporukeCell = $('#datum_isporukeCell');
	var prevoznikCell = $('#prevoznikCell');
	var potpis_vozacaCell = $('#potpis_vozacaCell');
	var primio_robuCell = $('#primio_robuCell');
	var fakturaCell = $('#fakturaCell');
	var stavka_otpremniceCell = $('#stavka_otpremniceCell');
   
 	$('#otpremnicaSubmit').on('click', function(event){
		var broj_otpremnice = broj_otpremniceInput.val();

		console.log('broj_otpremnice: ' + broj_otpremnice);
		
		var params = {
			'broj_otpremnice': broj_otpremnice
		}
		$.post("http://localhost:8080/api/otpremnice/pojedinacnaOtpremnica", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji otpremnice...')
			
			otpremnica = data;
			
			$('#broj_otpremniceCell').val(otpremnica.brojOtpremnice);
			$('#kupacCell').val(otpremnica.kupac);
			$('#adresa_isporukeCell').val(otpremnica.adresaIsporuke);
			$('#datum_isporukeCell').val(otpremnica.datumIsporuke);
			$('#prevoznikCell').val(otpremnica.prevoznik);
			$('#potpis_vozacaCell').val(otpremnica.potpisVozaca);
			$('#primio_robuCell').val(otpremnica.primioRobu);
			$('#fakturaCell').val(otpremnica.faktura.idFakture);
			$('#stavka_otpremniceCell').val(otpremnica.stavkaOtpremnice.idStavkeOtpremnice);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});