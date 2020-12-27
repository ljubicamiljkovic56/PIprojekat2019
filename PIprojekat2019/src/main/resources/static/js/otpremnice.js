var otpremnice = []

$(document).ready(function(){
	var otpremniceTable = $('#otpremniceTable');
	
	function getOtpremnice(){
	$.get("http://localhost:8080/api/otpremnice/all", function(data){
			console.log(data);
			
			otpremnice = data;
			
			populateTable(otpremnice);	

		});
	}
	
	function populateTable(otpremniceForTable){
		
		console.log('tabela?')
	
		for(it of otpremniceForTable){
			otpremniceTable.append(
				'<tr>' + 
					'<td>' + it.brojOtpremnice + '</td>' +
					'<td>' + it.kupac + '</td>' + 
					'<td>' + it.adresaIsporuke + '</td>' + 
					'<td>' + it.datumIsporuke + '</td>' + 
					'<td>' + it.prevoznik + '</td>' + 
					'<td>' + it.potpisVozaca + '</td>' + 
					'<td>' + it.primioRobu + '</td>' + 
					'<td>' + it.faktura.idFakture + '</td>' + 
					'<td>' + it.stavkaOtpremnice.idStavkeOtpremnice + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};
	

	getOtpremnice();
	console.log('dobavljene otpremnice?');
});