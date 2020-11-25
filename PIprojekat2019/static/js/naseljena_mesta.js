var mesta = []

$(document).ready(function(){
	var mestaTable = $('#mestaTable');
	
	function getMesta(){
	$.get("http://localhost:8080/api/mesto/all", function(data){
			console.log(data);
			
			mesta = data;
			
			populateTable(mesta);	

		});
	}
	
	function populateTable(mestaForTable){
		
		console.log('tabela?')
	
		for(it of mestaForTable){
			mestaTable.append(
				'<tr>' + 
					'<td>' + it.nazivMesta + '</td>' +
					'<td>' + it.pttBroj.toString() + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getMesta();
	console.log('dobavljena mesta?');
});