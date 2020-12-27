$(document).ready(function() {
	
	var faktura = []
	
	var broj_faktureInput = $('#broj_faktureInput');
	
	var broj_faktureCell = $('#broj_faktureCell');
	var datum_faktureCell = $('#datum_faktureCell');
	var datum_valuteCell = $('#datum_valuteCell');
	var ukupna_osnovicaCell = $('#ukupna_osnovicaCell');
	var ukupan_pdvCell = $('#ukupan_pdvCell');
	var ukupan_iznosCell = $('#ukupan_iznosCell');
	var status_faktureCell = $('#status_faktureCell');
	var stavka_faktureCell = $('#stavka_faktureCell');
	var poslovna_godinaCell = $('#poslovna_godinaCell');
	var poslovni_partnerCell = $('#poslovni_partnerCell');
	var preduzeceCell = $('#preduzeceCell');

   
 	$('#fakturaSubmit').on('click', function(event){
		var broj_fakture = broj_faktureInput.val();

		console.log('broj_fakture: ' + broj_fakture);
		
		var params = {
			'broj_fakture': broj_fakture
		}
		$.post("http://localhost:8080/api/fakture/pojedinacnaFaktura", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji fakture...')
			
			faktura = data;
			
			$('#broj_faktureCell').val(faktura.brojFakture);
			$('#datum_faktureCell').val(faktura.datumFakture);
			$('#datum_valuteCell').val(faktura.datumValute);
			$('#ukupna_osnovicaCell').val(faktura.ukupnaOsnovica);
			$('#ukupan_pdvCell').val(faktura.ukupanPDV);
			$('#ukupan_iznosCell').val(faktura.ukupanIznos);
			$('#status_faktureCell').val(faktura.statusFakture);
			$('#stavka_faktureCell').val(faktura.stavkaFakture.idStavke);
			$('#poslovna_godinaCell').val(faktura.poslovnaGodina.godina);
			$('#poslovni_partnerCell').val(faktura.poslovniPartner.nazivPoslovnogPartnera);
			$('#preduzeceCell').val(faktura.preduzece.nazivPreduzeca);
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});