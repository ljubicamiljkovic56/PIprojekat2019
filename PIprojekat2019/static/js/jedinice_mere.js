var jedinice = []

$(document).ready(function(){
	var jediniceTable = $('#jediniceTable');
	
	function getJedinice(){
	$.get("http://localhost:8080/api/jedinicemere/all", function(data){
			console.log(data);
			
			jedinice = data;
			
			populateTable(jedinice);	

		});
	}
	
	function populateTable(jediniceForTable){
		
		console.log('tabela?')
	
		for(it of jediniceForTable){
			jediniceTable.append(
				'<tr>' + 
					'<td>' + it.nazivJediniceMere + '</td>' +
					'<td>' + it.skraceniNaziv + '</td>' + 
					'<td>' +
				'</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getJedinice();
	console.log('dobavljene jedinice mere?');
});