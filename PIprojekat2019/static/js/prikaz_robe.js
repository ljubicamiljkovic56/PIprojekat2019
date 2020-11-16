var roba = []

$(document).ready(function(){
	var robaTable = $('#robaTable');
	
	function getRoba(){
	$.get("http://localhost:8080/api/roba/svaroba", function(data){
			console.log(data);
			
			roba = data;
			
			populateTable(roba);	

		});
	}
	
	function populateTable(robaForTable){
		
		console.log('tabela?')
	
		for(it of robaForTable){
			robaTable.append(
				'<tr>' + 
					'<td>' + it.naziv + '</td>' +
					'<td>' + it.opis + '</td>' + 
					'<td>' + it.roba + '</td>' +
					'<td>' + it.jedinicaMere + '</td>' +
					'<td>' + it.grupaRobe + '</td>' +
					'<td>' +
				'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getRoba();
	console.log('dobavljena roba?');
});