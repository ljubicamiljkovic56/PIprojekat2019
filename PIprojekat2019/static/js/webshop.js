var proizvodi = []

$(document).ready(function(){
	var proizvodiTable = $('#proizvodiTable');
	
	function getProizvodi(){
	$.get("http://localhost:8080/api/proizvodi/sviproizvodi", function(data){
			console.log(data);
			
			proizvodi = data;
			
			populateTable(proizvodi);	

		});
	}
	
	function populateTable(proizvodiForTable){
		
		console.log('tabela?')
	
		for(it of proizvodiForTable){
			proizvodiTable.append(
				'<tr>' + 
					'<td>' + it.naziv + '</td>' +
					'<td>' + it.cena + '</td>' + 
					'<td>' + it.opis + '</td>' +
					'<td>' +
				'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getProizvodi();
	console.log('dobavljeni proizvodi?');
});