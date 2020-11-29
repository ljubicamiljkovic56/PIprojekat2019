var fakture = []

$(document).ready(function(){
	var faktureTable = $('#faktureTable');
	
	function getFakture(){
	$.get("http://localhost:8080/api/fakture/all", function(data){
			console.log(data);
			
			fakture = data;
			
			populateTable(fakture);	

		});
	}
	
	function populateTable(faktureForTable){
		
		console.log('tabela?')
	
		for(it of faktureForTable){
			faktureTable.append(
				'<tr>' + 
					'<td>' + it.brojFakture + '</td>' +
					'<td>' + it.datumFakture + '</td>' + 
					'<td>' + it.datumValute + '</td>' + 
					'<td>' + it.ukupnaOsnovica + '</td>' + 
					'<td>' + it.ukupanPDV + '</td>' + 
					'<td>' + it.ukupanIznos + '</td>' + 
					'<td>' + it.statusFakture + '</td>' + 
					'<td>' + it.stavkaFakture + '</td>' + 
					'<td>' + it.poslovnaGodina.godina + '</td>' + 
					'<td>' + it.poslovniPartner.nazivPoslovnogPartnera + '</td>' + 
					'<td>' + it.preduzece.nazivPreduzeca + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};

	getFakture();
	console.log('dobavljene fakture?');
});