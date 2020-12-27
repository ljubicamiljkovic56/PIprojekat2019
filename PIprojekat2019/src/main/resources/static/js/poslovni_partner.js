$(document).ready(function() {
	
	var partner = []
	
	var naziv_poslovnog_partneraInput = $('#naziv_poslovnog_partneraInput');
	
	var naziv_poslovnog_partneraCell = $('#naziv_poslovnog_partneraCell');
	var adresaCell = $('#adresaCell');
	var telefonCell = $('#telefonCell');
	var faxCell = $('#faxCell'); 
	var emailCell = $('#emailCell');
	var vrsta_partneraCell = $('#vrsta_partneraCell');
	var mestoCell = $('#mestoCell');
   
 	$('#partnerSubmit').on('click', function(event){
		var naziv_poslovnog_partnera = naziv_poslovnog_partneraInput.val();

		console.log('naziv_poslovnog_partnera: ' + naziv_poslovnog_partnera);
		
		var params = {
			'naziv_poslovnog_partnera': naziv_poslovnog_partnera
		}
		$.post("http://localhost:8080/api/poslovnipartneri/pojedinacanPrikaz", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji poslovnog partnera...')
			
			partner = data;
			
			$('#naziv_poslovnog_partneraCell').val(partner.nazivPoslovnogPartnera);
			$('#adresaCell').val(partner.adresa);
			$('#telefonCell').val(partner.telefon);
			$('#faxCell').val(partner.fax);
			$('#emailCell').val(partner.email);
			$('#vrsta_partneraCell').val(partner.vrstaPartnera);
			$('#mestoCell').val(partner.naseljenoMesto.nazivMesta);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});