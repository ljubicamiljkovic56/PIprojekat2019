var partneri = []

$(document).ready(function(){
	var partneriTable = $('#partneriTable');
	
	function getPartneri(){
	$.get("http://localhost:8080/api/poslovnipartneri/all", function(data){
			console.log(data);
			
			partneri = data;
			
			populateTable(partneri);	

		});
	}
	
	function populateTable(partneriForTable){
		
		console.log('tabela?')
	
		for(it of partneriForTable){
			partneriTable.append(
				'<tr>' + 
					'<td>' + it.nazivPoslovnogPartnera + '</td>' +
					'<td>' + it.adresa + '</td>' + 
					'<td>' + it.telefon + '</td>' + 
					'<td>' + it.fax + '</td>' + 
					'<td>' + it.email + '</td>' + 
					'<td>' + it.vrstaPartnera + '</td>' + 
					'<td>' + it.naseljenoMesto.nazivMesta + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getPartneri();
	console.log('dobavljeni poslovni partneri?');
});