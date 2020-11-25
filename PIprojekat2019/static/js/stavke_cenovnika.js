var stavke = []

$(document).ready(function(){
	var stavkeTable = $('#stavkeTable');
	
	function getStavke(){
	$.get("http://localhost:8080/api/stavkecenovnika/all", function(data){
			console.log(data);
			
			stavke = data;
			
			populateTable(stavke);	

		});
	}
	
	function populateTable(stavkeForTable){
		
		console.log('tabela?')
	
		for(it of stavkeForTable){
			stavkeTable.append(
				'<tr>' + 
					'<td>' + it.cena + '</td>' +
					'<td>' + it.cenovnik.datumPocetkaVazenja + '</td>' + 
					'<td>' + it.robaUsluga.nazivRobeUsluge + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getStavke();
	console.log('dobavljene stavke cenovnika?');
});