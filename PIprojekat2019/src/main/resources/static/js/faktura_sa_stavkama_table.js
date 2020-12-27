var fakture = []

$(document).ready(function(){
	var faktureTable = $('#faktureTable');
	
	function getFakture(){
	$.get("http://localhost:8080/api/fakture/fakturaSaStavkamaTabela", function(data){
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
					'<td>' + it.idFakture + '</td>' +
					'<td>' + it.brojFakture + '</td>' + 
					'<td>' + it.datumFakture +'</td>' + 
					'<td>' + it.datumValute +'</td>' + 
					'<td>' + it.ukupnaOsnovica +'</td>' +
					'<td>' + it.ukupanPDV +'</td>' +
					'<td>' + it.ukupanIznos +'</td>' +
					'<td>' + it.statusFakture +'</td>' +
					'<td>' + it.stavkaFakture.idStavke +'</td>' +
					'<td>' + it.stavkaFakture.kolicina +'</td>' +
					'<td>' + it.stavkaFakture.rabat +'</td>' +
					'<td>' + it.stavkaFakture.jedinicnaCena +'</td>' +
					'<td>' + it.stavkaFakture.pdvStopa +'</td>' +
					'<td>' + it.stavkaFakture.osnovicaZaPDV +'</td>' +
					'<td>' + it.stavkaFakture.iznosPDV +'</td>' +
					'<td>' + it.stavkaFakture.ukupanIznos +'</td>' +
					'<td>' + it.poslovnaGodina.idGodine +'</td>' +
					'<td>' + it.poslovnaGodina.godina +'</td>' +
					'<td>' + it.poslovnaGodina.zakljucena +'</td>' +
					//'<td>' + it.idPreduzeca +'</td>' +
				'</tr>'
			)
		}
	};
	

	getFakture();
	console.log('dobavljene fakture?');
});