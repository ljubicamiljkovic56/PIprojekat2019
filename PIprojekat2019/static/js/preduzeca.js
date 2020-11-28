var preduzeca = []

$(document).ready(function(){
	var preduzecaTable = $('#preduzecaTable');
	
	function getPreduzeca(){
	$.get("http://localhost:8080/api/preduzece/all", function(data){
			console.log(data);
			
			preduzeca = data;
			
			populateTable(preduzeca);	

		});
	}
	
	function populateTable(preduzecaForTable){
		
		console.log('tabela?')
	
		for(it of preduzecaForTable){
			preduzecaTable.append(
				'<tr>' + 
					'<td>' + it.nazivPreduzeca + '</td>' +
					'<td>' + it.adresa + '</td>' + 
					'<td>' + it.brojTelefona + '</td>' + 
					'<td>' + it.fax + '</td>' + 
					'<td>' + it.poslovnaGodina.godina + '</td>' + 
					'<td>' + it.naseljenoMesto.nazivMesta + '</td>' + 
					'<td>' + it.poslovniPartner.nazivPoslovnogPartnera + '</td>' + 
					'<td>' + it.cenovnik.datumPocetkaVazenja + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	getPreduzeca();
	console.log('dobavljena preduzeca?');
});