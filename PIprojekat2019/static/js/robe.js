var robe = []

$(document).ready(function(){
	var robaTable = $('#robaTable');
	
	function getRoba(){
	$.get("http://localhost:8080/api/roba/all", function(data){
			console.log(data);
			
			robe = data;
			
			populateTable(robe);	

		});
	}
	
	function populateTable(robeForTable){
		
		console.log('tabela?')
	
		for(it of robeForTable){
			robaTable.append(
				'<tr>' + 
					'<td>' + it.nazivRobeUsluge + '</td>' +
					'<td>' + it.opis + '</td>' + 
					'<td>' + it.roba +'</td>' + 
					'<td>' + it.jedinicaMere.nazivJediniceMere +'</td>' + 
					'<td>' + it.grupaRobeUsluga.nazivGrupe +'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getRoba();
	console.log('dobavljea roba?');
});