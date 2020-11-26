var stavke = []

$(document).ready(function(){
	var stavkeTable = $('#stavkeTable');
	
	function getStavke(){
	$.get("http://localhost:8080/api/stavkefakture/all", function(data){
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
					'<td>' + it.kolicina.toString() + '</td>' +
					'<td>' + it.rabat.toString() + '</td>' + 
					'<td>' + it.jedinicnaCena.toString() + '</td>' + 
					'<td>' + it.pdvStopa.toString() +'</td>' +
					'<td>' + it.osnovicaZaPDV.toString()+'</td>' +
					'<td>' + it.iznosPDV.toString() +'</td>' + 
					'<td>' + it.ukupanIznos.toString() + '</td>' +
					'<td>' + it.preduzece.nazivPreduzeca +'</td>' + 
					'<td>' + it.robaUsluga.nazivRobeUsluge +'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getStavke();
	console.log('dobavljene stavke fakture?');
});