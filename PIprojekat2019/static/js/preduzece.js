$(document).ready(function() {
	
	var preduzece = []
	
	var naziv_preduzecaInput = $('#naziv_preduzecaInput');
	
	var naziv_preduzecaCell = $('#naziv_preduzecaCell');
	var adresaCell = $('#adresaCell');
	var broj_telefonaCell = $('#broj_telefonaCell');
	var faxCell = $('#faxCell');
	var godinaCell = $('#godinaCell');
	var mestoCell = $('#mestoCell');
	var poslovni_partnerCell = $('#poslovni_partnerCell');
	var cenovnikCell = $('#cenovnikCell');

   
 	$('#preduzeceSubmit').on('click', function(event){
		var naziv_preduzeca = naziv_preduzecaInput.val();

		console.log('naziv_preduzeca: ' + naziv_preduzeca);
		
		var params = {
			'naziv_preduzeca': naziv_preduzeca
		}
		$.post("http://localhost:8080/api/preduzece/pojedinacnoPreduzece", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji preduzeca...')
			
			preduzece = data;
			
			$('#naziv_preduzecaCell').val(preduzece.nazivPreduzeca);
			$('#adresaCell').val(preduzece.adresa);
			$('#broj_telefonaCell').val(preduzece.brojTelefona);
			$('#faxCell').val(preduzece.fax);
			$('#godinaCell').val(preduzece.poslovnaGodina.godina);
			$('#mestoCell').val(preduzece.naseljenoMesto.nazivMesta);
			$('#poslovni_partnerCell').val(preduzece.poslovniPartner.nazivPoslovnogPartnera);
			$('#cenovnikCell').val(preduzece.cenovnik.datumPocetkaVazenja);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});