var narudzbenice = []

$(document).ready(function(){
	var narudzbeniceTable = $('#narudzbeniceTable');
	
	function getNarudzbenice(){
	$.get("http://localhost:8080/api/narudzbenica/all", function(data){
			console.log(data);
			
			narudzbenice = data;
			
			populateTable(narudzbenice);	

		});
	}
	
	function populateTable(narudzbeniceForTable){
		
		console.log('tabela?')
	
		for(it of narudzbeniceForTable){
			narudzbeniceTable.append(
				'<tr>' + 
					'<td>' + it.nazivRobe + '</td>' +
					'<td>' + it.jedinicaMere + '</td>' + 
					'<td>' + it.kolicina +'</td>' + 
					'<td>' + it.cena +'</td>' + 
					'<td>' + it.iznos +'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getNarudzbenice();
	console.log('dobavljene narudzbenice?');
});