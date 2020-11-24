var grupe = []

$(document).ready(function(){
	var grupeTable = $('#grupeTable');
	
	function getGrupe(){
	$.get("http://localhost:8080/api/gruperobe/all", function(data){
			console.log(data);
			
			grupe = data;
			
			populateTable(grupe);	

		});
	}
	
	function populateTable(grupeForTable){
		
		console.log('tabela?')
	
		for(it of grupeForTable){
			grupeTable.append(
				'<tr>' + 
					'<td>' + it.nazivGrupe + '</td>' +
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getGrupe();
	console.log('dobavljene grupe robe?');
});