$(document).ready(function(){
	
	var kolicinaInput = $('#kolicinaInput');
	var rabatInput = $('#rabatInput');
	var jedinicna_cenaInput = $('#jedinicna_cenaInput');
	var nova_cenaInput = $('#nova_cenaInput');
	var pdv_stopaInput = $('#pdv_stopaInput');
	var osnovica_pdvInput = $('#osnovica_pdvInput');
	var iznos_pdvInput = $('#iznos_pdvInput');
	var ukupan_iznosInput = $('#ukupan_iznosInput');
	var naziv_preduzecaInput = $('#naziv_preduzecaInput');
	var robaInput = $('#robaInput');

	$('#stavkaSubmit').on('click', function(event){
		var kolicina = kolicinaInput.val();
		var rabat = rabatInput.val();
		var jedinicna_cena = jedinicna_cenaInput.val();
		var nova_cena = nova_cenaInput.val();
		var pdv_stopa = pdv_stopaInput.val();
		var osnovica_pdv = osnovica_pdvInput.val();
		var iznos_pdv = iznos_pdvInput.val();
		var ukupan_iznos = ukupan_iznosInput.val();
		var naziv_preduzeca = naziv_preduzecaInput.val();
		var roba = robaInput.val();
		
		console.log('kolicina: ' + kolicina)
		console.log('rabat: ' + rabat);
		console.log('jedinicna_cena: ' + jedinicna_cena);
		console.log('nova_cena: ' + nova_cena);
		console.log('pdv_stopa: ' + pdv_stopa);
		console.log('osnovica_pdv: ' + osnovica_pdv);
		console.log('iznos_pdv: ' + iznos_pdv);
		console.log('ukupan_iznos: ' + ukupan_iznos);
		console.log('naziv_preduzeca: ' + naziv_preduzeca);
		console.log('roba: ' + roba);
		
		var params = {
			'kolicina': kolicina,
			'rabat': rabat,
			'jedinicna_cena': jedinicna_cena,
			'nova_cena': nova_cena,
			'pdv_stopa': pdv_stopa,
			'osnovica_pdv': osnovica_pdv,
			'iznos_pdv': iznos_pdv,
			'ukupan_iznos': ukupan_iznos,
			'naziv_preduzeca': naziv_preduzeca,
			'roba': roba
		}
		$.post("http://localhost:8080/api/stavkefakture/izmeniStavkuFakture/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena stavke fakture');
			
			window.location.href = "stavke_fakture.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});