var cenovnici = []

$(document).ready(function(){
	var cenovniciTable = $('#cenovniciTable');
	
	function getCenovnici(){
	$.get("http://localhost:8080/api/cenovnici/all", function(data){
			console.log(data);
			
			cenovnici = data;
			
			populateTable(cenovnici);	

		});
	}
	
	function populateTable(cenovniciForTable){
		
		console.log('tabela?')
	
		for(it of cenovniciForTable){
			cenovniciTable.append(
				'<tr>' + 
					'<td>' + it.datumPocetkaVazenja + '</td>' +
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getCenovnici();
	console.log('dobavljeni cenovnici?');
});