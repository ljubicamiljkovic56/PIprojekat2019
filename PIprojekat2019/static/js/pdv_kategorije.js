var kategorije = []

$(document).ready(function(){
	var kategorijeTable = $('#kategorijeTable');
	
	function getKategorije(){
	$.get("http://localhost:8080/api/pdvkategorije/all", function(data){
			console.log(data);
			
			kategorije = data;
			
			populateTable(kategorije);	

		});
	}
	
	function populateTable(kategorijeForTable){
		
		console.log('tabela?')
	
		for(it of kategorijeForTable){
			kategorijeTable.append(
				'<tr>' + 
					'<td>' + it.nazivKategorije + '</td>' +
					'<td>' + it.pdvStope + '</td>' + 
					'<td>' +
				'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getKategorije();
	console.log('dobavljene pdv kategorije?');
});