var pdvstope = []

$(document).ready(function(){
	var pdvstopeTable = $('#pdvstopeTable');
	
	function getPDVStope(){
	$.get("http://localhost:8080/api/pdvstope/all", function(data){
			console.log(data);
			
			pdvstope = data;
			
			populateTable(pdvstope);	

		});
	}
	
	function populateTable(pdvstopeForTable){
		
		console.log('tabela?')
	
		for(it of pdvstopeForTable){
			pdvstopeTable.append(
				'<tr>' + 
					'<td>' + it.datumVazenja + '</td>' +
					'<td>' + it.procenat + '</td>' +
					'<td>' + it.nazivKategorije + '</td>' + 
					'<td>' +
				'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getPDVStope();
	console.log('dobavljene pdv stope?');
});