//var kategorije = []
//
//$(document).ready(function(){
//	var kategorijeTable = $('#kategorijeTable');
//	
//	function getKategorije(){
//	$.get("http://localhost:8080/api/pdvkategorije/all", function(data){
//			console.log(data);
//			
//			kategorije = data;
//			
//			populateTable(kategorije);	
//
//		});
//	}
//	
//	function populateTable(kategorijeForTable){
//		
//		console.log('tabela?')
//	
//		for(it of kategorijeForTable){
//			kategorijeTable.append(
//				'<tr>' + 
//					'<td>' + it.nazivKategorije + '</td>' +
//					'<td>' + it.pdvStope.idStope + '</td>' + 
//					'<td>' +
//				'</td>' + 
//					'<td>' +
//					'</td>' + 
//				'</tr>'
//			)
//		}
//	};
//	
//
//	getKategorije();
//	console.log('dobavljene pdv kategorije?');
//});
function getPDVKategorije(){
	dobaviPDVKategorije();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		dodajPDVKategoriju();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntity());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntity();
		if(name!=null){
			$('#deletePromptText').text("Obrisati: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiPDVKategoriju();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}
function dobaviPDVKategorije() {
	$.ajax({
		url : "http://localhost:8080/api/pdvkategorije/all"
	}).then(
			function(data) {
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"nazivKategorije\">" + data[i].nazivKategorije + "</td>"
//							+ "<td class=\"skraceniNaziv\">" + data[i].skraceniNaziv + "</td>"
//							+ "<td class=\"idCell\">" + data[i].id + "</td>" +
//						"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
	
	$("#first").click(function(){
		goFirst()
	 });
	
	$("#next").click(function(){
		goNext()
	 });
}
function dodajPDVKategoriju(){
	var nazivKategorijeInput = $('#nazivKategorijeInput');
	
	var naziv_kategorije = naziv_kategorije.val();
	
	console.log('naziv_kategorije: ' + naziv_kategorije);
	
	var kategorija = {
			"naziv_kategorije": naziv_kategorije
	};
	console.log(kategorija);
	console.log(JSON.stringify(kategorija));
	$.ajax({
			url: "/api/pdvkategorije/",
			type: "POST",
			data: JSON.stringify(kategorija),
			contentType: "application/json",
			datatype: "json",
			success: function(data) {
				dobaviPDVKategorije();
				$("#nazivKategorijeInput").val("");
			}
	});

}


function obrisiPDVKategoriju(){
	var id = getIdOfSelectedEntity();
	$.ajax({
    	url: "http://localhost:8080/api/pdvkategorije/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviJediniceMere();
        }
	});
}