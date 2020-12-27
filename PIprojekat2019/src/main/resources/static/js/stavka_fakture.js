$(document).ready(function() {
	
	var stavke = []
	
	var jedinicna_cenaInput = $('#jedinicna_cenaInput');
	
	 var kolicinaCell = $('#kolicinaCell');
	 var rabatCell = $('#rabatCell');
	 var jedinicna_cenaCell = $('#jedinicna_cenaCell');
	 var pdv_stopaCell = $('#pdv_stopaCell');
	 var osnovicaCell = $('#osnovicaCell');
	 var iznos_pdvCell = $('#iznos_pdvCell');
	 var ukupan_iznosCell = $('#ukupan_iznosCell');
	 var preduzeceCell = $('#preduzeceCell');
	 var robaCell = $('#robaCell');
   
 	$('#stavkaSubmit').on('click', function(event){
		var jedinicna_cena = jedinicna_cenaInput.val();

		console.log('jedinicna_cena: ' + jedinicna_cena);
		
		var params = {
			'jedinicna_cena': jedinicna_cena
		}
		$.post("http://localhost:8080/api/stavkefakture/pojedinacnaStavkaFakture", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji stavke fakture...')
			
			stavke = data;
			
			$('#kolicinaCell').val(stavke.kolicina);
			$('#rabatCell').val(stavke.rabat);
			$('#jedinicna_cenaCell').val(stavke.jedinicnaCena);
			$('#pdv_stopaCell').val(stavke.pdvStopa);
			$('#osnovicaCell').val(stavke.osnovicaZaPDV);
			$('#iznos_pdvCell').val(stavke.iznosPDV);
			$('#ukupan_iznosCell').val(stavke.ukupanIznos);
			$('#preduzeceCell').val(stavke.preduzece.nazivPreduzeca);
			$('#robaCell').val(stavke.robaUsluga.nazivRobeUsluge);
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});