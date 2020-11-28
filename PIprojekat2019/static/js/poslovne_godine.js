var godine = []

$(document).ready(function(){
	var godineTable = $('#godineTable');
	
	function getGodine(){
	$.get("http://localhost:8080/api/poslovnegodine/all", function(data){
			console.log(data);
			
			godine = data;
			
			populateTable(godine);	

		});
	}
	
	function populateTable(godineForTable){
		
		console.log('tabela?')
	
		for(it of godineForTable){
			godineTable.append(
				'<tr>' + 
					'<td>' + it.godina + '</td>' +
					'<td>' + it.zakljucena + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	
	getGodine();
	console.log('dobavljene godine?');
});