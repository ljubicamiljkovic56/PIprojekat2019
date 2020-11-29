$(document).ready(function(){
	
	var naziv_poslovnog_partneraInput = $('#naziv_poslovnog_partneraInput');
	var novi_nazivInput = $('#novi_nazivInput');
	var adresaInput = $('#adresaInput');
	var telefonInput = $('#telefonInput');
	var faxInput = $('#faxInput');
	var emailInput = $('#emailInput');
	var vrsta_partneraInput = $('#vrsta_partneraInput');
	var mestoInput = $('#mestoInput');

	$('#partnerSubmit').on('click', function(event){
		var naziv_poslovnog_partnera = naziv_poslovnog_partneraInput.val();
		var novi_naziv = novi_nazivInput.val();
		var adresa = adresaInput.val();
		var telefon = telefonInput.val();
		var fax = faxInput.val();
		var email = emailInput.val();
		var vrsta_partnera = vrsta_partneraInput.val();
		var mesto = mestoInput.val();
		
		
		console.log('naziv_poslovnog_partnera: ' + naziv_poslovnog_partnera)
		console.log('novi_naziv: ' + novi_naziv);
		console.log('adresa: ' + adresa);
		console.log('telefon: ' + telefon);
		console.log('fax: ' + fax);
		console.log('email: ' + email);
		console.log('vrsta_partnera: ' + vrsta_partnera);
		console.log('mesto: ' + mesto);
		
		var params = {
			'naziv_poslovnog_partnera': naziv_poslovnog_partnera,
			'novi_naziv': novi_naziv,
			'adresa': adresa,
			'telefon': telefon,
			'fax': fax,
			'email': email,
			'vrsta_partnera': vrsta_partnera,
			'mesto': mesto
		}
		$.post("http://localhost:8080/api/poslovnipartneri/izmeniPoslovnogPartnera/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena poslovnog partnera')
			
			window.location.href = "poslovni_partneri.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});