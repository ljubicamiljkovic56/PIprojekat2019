$(document).ready(function(){
	
	var naziv_preduzecaInput = $('#naziv_preduzecaInput');
	var novi_nazivInput = $('#novi_nazivInput');
	var adresa_preduzecaInput = $('#adresa_preduzecaInput');
	var broj_telefonaInput = $('#broj_telefonaInput');
	var fax_preduzecaInput = $('#fax_preduzecaInput');
	var godinaInput = $('#godinaInput');
	var naziv_mestaInput = $('#naziv_mestaInput');
	var naziv_poslovnog_partneraInput = $('#naziv_poslovnog_partneraInput');
	var datum_vazenjaInput = $('#datum_vazenjaInput');

	$('#preduzeceSubmit').on('click', function(event){
		var naziv_preduzeca = naziv_preduzecaInput.val();
		var novi_naziv = novi_nazivInput.val();
		var adresa_preduzeca = adresa_preduzecaInput.val();
		var broj_telefona = broj_telefonaInput.val();
		var fax_preduzeca = fax_preduzecaInput.val();
		var godina = godinaInput.val();
		var naziv_mesta = naziv_mestaInput.val();
		var naziv_poslovnog_partnera = naziv_poslovnog_partneraInput.val();
		var datum_vazenja = datum_vazenjaInput.val();
		
		console.log('naziv_preduzeca: ' + naziv_preduzeca)
		console.log('novi_naziv: ' + novi_naziv);
		console.log('adresa_preduzeca: ' + adresa_preduzeca);
		console.log('broj_telefona: ' + broj_telefona);
		console.log('fax_preduzeca: ' + fax_preduzeca);
		console.log('godina: ' + godina);
		console.log('naziv_mesta: ' + naziv_mesta);
		console.log('naziv_poslovnog_partnera: ' + naziv_poslovnog_partnera);
		console.log('datum_vazenja: ' + datum_vazenja);
		
		var params = {
			'naziv_preduzeca': naziv_preduzeca,
			'novi_naziv': novi_naziv,
			'adresa_preduzeca': adresa_preduzeca,
			'broj_telefona': broj_telefona,
			'fax_preduzeca': fax_preduzeca,
			'godina': godina,
			'naziv_mesta': naziv_mesta,
			'naziv_poslovnog_partnera': naziv_poslovnog_partnera,
			'datum_vazenja': datum_vazenja
		}
		$.post("http://localhost:8080/api/preduzece/izmeniPreduzece/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena preduzeca')
			
			window.location.href = "preduzeca.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});