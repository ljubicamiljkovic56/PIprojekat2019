var otpremnice = []

$(document).ready(function(){
	var otpremniceTable = $('#otpremniceTable');
	
	function getOtpremnice(){
	$.get("http://localhost:8080/api/otpremnice/otpremnicaSaFakturom", function(data){
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
					'<td>' + it.idOtpremnice + '</td>' +
					'<td>' + it.brojOtpremnice + '</td>' + 
					'<td>' + it.kupac +'</td>' + 
					'<td>' + it.adresaIsporuke +'</td>' + 
					'<td>' + it.datumIsporuke +'</td>' +
					'<td>' + it.prevoznik +'</td>' +
					'<td>' + it.potpisVozaca +'</td>' +
					'<td>' + it.primioRobu +'</td>' +
					'<td>' + it.stavkaOtpremnice.idStavkeOtpremnice +'</td>' +
					'<td>' + it.stavkaOtpremnice.redniBrojProizvoda +'</td>' +
					'<td>' + it.faktura.idFakture +'</td>' +
					'<td>' + it.faktura.brojFakture +'</td>' +
					'<td>' + it.faktura.datumFakture +'</td>' +
					'<td>' + it.faktura.datumValute +'</td>' +
					'<td>' + it.faktura.ukupnaOsnovica +'</td>' +
					'<td>' + it.faktura.ukupanPDV +'</td>' +
					'<td>' + it.faktura.ukupanIznos +'</td>' +
					'<td>' + it.faktura.statusFakture +'</td>' +
				'</tr>'
			)
		}
	};
	

	getOtpremnice();
	console.log('dobavljene otpremnice?');
});