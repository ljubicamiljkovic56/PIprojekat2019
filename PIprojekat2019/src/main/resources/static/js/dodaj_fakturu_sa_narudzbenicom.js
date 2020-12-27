$(document).ready(function(){
	var broj_faktureInput = $('#broj_faktureInput');
	var datum_faktureInput = $('#datum_faktureInput');
	var datum_valuteInput = $('#datum_valuteInput');
	var ukupna_osnovicaInput = $('#ukupna_osnovicaInput');
	var ukupan_pdvInput = $('#ukupan_pdvInput');
	var ukupan_iznosInput = $('#ukupan_iznosInput');
	var status_faktureInput = $('#status_faktureInput');
	var stavka_faktureInput = $('#stavka_faktureInput');
	var poslovna_godinaInput = $('#poslovna_godinaInput');
	var poslovni_partnerInput = $('#poslovni_partnerInput');
	var preduzeceInput = $('#preduzeceInput');

	var nazivInput = $('#nazivInput');
	var jedinica_mereInput = $('#jedinica_mereInput');
	var cenaInput = $('#cenaInput');
	var kolicinaInput = $('#kolicinaInput');
	var iznosInput = $('#iznosInput');

	
	$('#fakturaSubmit').on('click', function(event){
		var broj_fakture = broj_faktureInput.val();
		var datum_fakture = datum_faktureInput.val();
		var datum_valute = datum_valuteInput.val();
		var ukupna_osnovica = ukupna_osnovicaInput.val();
		var ukupan_pdv = ukupan_pdvInput.val();
		var ukupan_iznos = ukupan_iznosInput.val();
		var status_fakture = status_faktureInput.val();
		var stavka_fakture = stavka_faktureInput.val();
		var poslovna_godina = poslovna_godinaInput.val();
		var poslovni_partner = poslovni_partnerInput.val();
		var preduzece = preduzeceInput.val();
		
		var naziv = nazivInput.val();
		var jedinica_mere = jedinica_mereInput.val();
		var cena = cenaInput.val();
		var kolicina = kolicinaInput.val();
		var iznos = iznosInput.val();
		
		console.log('broj_fakture: ' + broj_fakture)
		console.log('datum_fakture: ' + datum_fakture);
		console.log('datum_valute: ' + datum_valute);
		console.log('ukupna_osnovica: ' + ukupna_osnovica);
		console.log('ukupan_pdv: ' + ukupan_pdv);
		console.log('ukupan_iznos: ' + ukupan_iznos);
		console.log('status_fakture: ' + status_fakture);
		console.log('stavka_fakture: ' + stavka_fakture);
		console.log('poslovna_godina: ' + poslovna_godina);
		console.log('poslovni_partner: ' + poslovni_partner);
		console.log('preduzece: ' + preduzece);
		
		console.log('naziv: ' + naziv);
		console.log('jedinica_mere: ' + jedinica_mere);
		console.log('cena: ' + cena);
		console.log('kolicina: ' + kolicina);
		console.log('iznos: ' + iznos);
		
		var params = {
			'broj_fakture': broj_fakture,
			'datum_fakture': datum_fakture,
			'datum_valute': datum_valute,
			'ukupna_osnovica': ukupna_osnovica,
			'ukupan_pdv': ukupan_pdv,
			'ukupan_iznos': ukupan_iznos,
			'status_fakture': status_fakture,
			'stavka_fakture': stavka_fakture,
			'poslovna_godina': poslovna_godina,
			'poslovni_partner': poslovni_partner,
			'preduzece': preduzece,
			'naziv': naziv,
			'jedinica_mere': jedinica_mere,
			'cena': cena,
			'kolicina': kolicina,
			'iznos': iznos
		
			
		}
		$.post("http://localhost:8080/api/narudzbenica/fakturaINarudzbenica", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova faktura sa narudzbenicom')
			
			window.location.href = "webshop.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});