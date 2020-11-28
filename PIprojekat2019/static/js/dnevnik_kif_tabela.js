var dnevnik = []
$(document).ready(function() { 
	
var dnevnikTable = $('#dnevnikTable');
var datum_fakture_tabelaInput = $('#datum_fakture_tabelaInput');
	
	$('#fakturaSubmit').on('click', function(event){
		var datum_fakture_tabela = datum_fakture_tabelaInput.val();
	
		console.log('datum_fakture_tabela: ' + datum_fakture_tabela);
				
		var params = {
					'datum_fakture_tabela': datum_fakture_tabela
		}
	$.post("http://localhost:8080/api/fakture/KIFtabela", params, function(data){
			console.log(data);
			
			dnevnik = data;
			
			populateTable(dnevnik);	

		});
	})
	
	function populateTable(dnevnikForTable){
		
		console.log('tabela?')
	
		for(it of dnevnikForTable){
			dnevnikTable.append(
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
	

	//getFakture();
	console.log('dobavljene fakture?');
//	
//	var datum_fakture_tabelaInput = $('#datum_fakture_tabelaInput');
//	
// 	$('#fakturaSubmit').on('click', function(event){
//		var datum_fakture_tabela = datum_fakture_tabelaInput.val();
//
//		console.log('datum_fakture_tabela: ' + datum_fakture_tabela);
//		
//		var params = {
//			'datum_fakture_tabela': datum_fakture_tabela
//		}
//		$.post("http://localhost:8080/api/fakture/KIFtabela", params, function(data) {
//			console.log('ispis...')
//			console.log(data);
//			
//			alert('Tabela...')
//			
//			dnevnik = data;
//			
//			 
//		 	function populateTable(dnevnikForTable){
//				
//				console.log('tabela?')
//			
//				for(it of dnevnikForTable){
//					dnevnikTable.append(
//						'<tr>' + 
//							'<td>' + it.idFakture + '</td>' +
//							'<td>' + it.brojFakture + '</td>' + 
//							'<td>' + it.datumFakture +'</td>' + 
//							'<td>' + it.datumValute +'</td>' + 
//							'<td>' + it.ukupnaOsnovica +'</td>' +
//							'<td>' + it.ukupanPDV +'</td>' +
//							'<td>' + it.ukupanIznos +'</td>' +
//							'<td>' + it.statusFakture +'</td>' +
//							'<td>' + it.stavkaFakture.idStavke +'</td>' +
//							'<td>' + it.stavkaFakture.kolicina +'</td>' +
//							'<td>' + it.stavkaFakture.rabat +'</td>' +
//							'<td>' + it.stavkaFakture.jedinicnaCena +'</td>' +
//							'<td>' + it.stavkaFakture.pdvStopa +'</td>' +
//							'<td>' + it.stavkaFakture.osnovicaZaPDV +'</td>' +
//							'<td>' + it.stavkaFakture.iznosPDV +'</td>' +
//							'<td>' + it.stavkaFakture.ukupanIznos +'</td>' +
//							'<td>' + it.poslovnaGodina.idGodine +'</td>' +
//							'<td>' + it.poslovnaGodina.godina +'</td>' +
//							'<td>' + it.poslovnaGodina.zakljucena +'</td>' +
//							//'<td>' + it.idPreduzeca +'</td>' +
//						'</tr>'
//					)
//				}
//			};	
//			
//			populateTable(dnevnik);
//			
//		});
//		console.log('slanje poruke');
//		event.preventDefault();
//		return false;
//	});
//	

	
});