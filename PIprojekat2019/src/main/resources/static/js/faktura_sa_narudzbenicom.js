var fakture = []

$(document).ready(function(){
	var faktureTable = $('#faktureTable');
	
	function getFakture(){
	$.get("http://localhost:8080/api/narudzbenica/fakturaNarudzbenicaTable", function(data){
			console.log(data);
			
			fakture = data;
			
			populateTable(fakture);	

		});
	}
	
	function populateTable(faktureForTable){
		
		console.log('tabela?')
	
		for(it of faktureForTable){
			faktureTable.append(
				'<tr>' + 
					'<td>' + it.nazivRobe + '</td>' + 
					'<td>' + it.jedinicaMere + '</td>' + 
					'<td>' + it.cena + '</td>' + 
					'<td>' + it.kolicina + '</td>' + 
					'<td>' + it.iznos + '</td>' + 
					'<td>' + it.faktura.brojFakture + '</td>' +
					'<td>' + it.faktura.datumFakture + '</td>' + 
					'<td>' + it.faktura.datumValute + '</td>' + 
					'<td>' + it.faktura.ukupnaOsnovica + '</td>' + 
					'<td>' + it.faktura.ukupanPDV + '</td>' + 
					'<td>' + it.faktura.ukupanIznos + '</td>' + 
					'<td>' + it.faktura.statusFakture + '</td>' + 
					'<td>' +
					'</td>' + 
				'</tr>'
			)
		}
	};

	getFakture();
	console.log('dobavljene fakture?');
});