var stavke = []

$(document).ready(function(){
	var stavkeTable = $('#stavkeTable');
	
	function getStavkeOtpremnice(){
	$.get("http://localhost:8080/api/stavkeotpremnice/all", function(data){
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
					'<td>' + it.redniBrojProizvoda + '</td>' +
					'<td>' + it.jedinicaMere + '</td>' + 
					'<td>' + it.cena + '</td>' + 
					'<td>' + it.kolicina + '</td>' + 
					'<td>' + it.napomena + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getStavkeOtpremnice();
	console.log('dobavljene stavke otpremnice?');
});