function getFakture() {
	dobaviFakture();

	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		//dodajFakturu();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityFaktura());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		//izmeniFakturu();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	//brisanje
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityFaktura();
		if(name!=null){
			$('#deletePromptText').text("Obrisati: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiFakturu();
		$('#deletePromptModal').modal('hide');
	});
	
	//storniranje
	$(document).on("click", '#storno', function(event){
		var name = getNameOfSelectedEntityFaktura();
		if(name!=null){
			$('#stornoPromptText').text("Storniraj: " + name);
			$('#stornoPromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.stornoPromptClose', function(event){
		$('#stornoPromptModal').modal('hide');
	});
	
	$(document).on("click", '#doStorniraj', function(event){
		stornirajFakturu();
		$('#stornoPromptModal').modal('hide');
	});
	
	//export u xml
	$(document).on("click", '#export', function(event){
		var name = getNameOfSelectedEntityFaktura();
		if(name!=null){
			$('#exportPromptText').text("Export fakture broj: " + name);
			$('#exportPromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.exportPromptClose', function(event){
		$('#exportPromptModal').modal('hide');
	});
	
	$(document).on("click", '#doExport', function(event){
		exportFakture();
		$('#exportPromptModal').modal('hide');
	});
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviFakture() {
	$.ajax({
		url : "http://localhost:8080/api/fakture/all"
	}).then(
			function(data) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"brojFakture\">" + data[i].brojFakture + "</td>"
							+ "<td class=\"datumFakture\">" + data[i].datumFakture + "</td>"
							+ "<td class=\"datumValute\">" + data[i].datumValute + "</td>"
							+ "<td class=\"ukupnaOsnovica\">" + data[i].ukupnaOsnovica + "</td>"
							+ "<td class=\"ukupanPDV\">" + data[i].ukupanPDV + "</td>"
							+ "<td class=\"ukupanIznos\">" + data[i].ukupanIznos + "</td>"
							+ "<td class=\"statusFakture\">" + data[i].statusFakture + "</td>"
							+ "<td class=\"godina\">" + data[i].poslovnaGodina.godina + "</td>"
							+ "<td class=\"narudzbenica\">" + data[i].narudzbenica.brojNarudzbenice + "</td>"
							+ "<td class=\"preduzece\">" + data[i].preduzece.nazivPreduzeca + "</td>"
							+ "<td class=\"poslovniPartner\">" + data[i].poslovniPartner.nazivPoslovnogPartnera + "</td>"
							+ "<td class=\"idFakture\">" + data[i].idFakture + "</td>"
						"</tr>"
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

function obrisiFakturu(){
	var id = getIdOfSelectedEntityFaktura();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/fakture/obrisiFakturu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviFakture();
        }
	});
}

function stornirajFakturu(){
	var id = getIdOfSelectedEntityFaktura();
	console.log(id);
	var broj_fakture = getNameOfSelectedEntityFaktura();
	
	$('#doStorniraj').on('click', function(event){
		console.log('broj_fakture: ' + broj_fakture);
		
		var params = {
				'broj_fakture': broj_fakture
		}
		
		$.post("http://localhost:8080/api/fakture/stornirajFakturu", params, function(data) {
			console.log('ispis...')
			
			alert('Stornirana je faktura')
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function exportFakture(){
	var id = getIdOfSelectedEntityFaktura();
	console.log(id);
	var broj_fakture = getNameOfSelectedEntityFaktura();
	
	$('#doExport').on('click', function(event){
		console.log('broj_fakture: ' + broj_fakture);
		
		var params = {
				'broj_fakture': broj_fakture
		}
		
		$.post("http://localhost:8080/api/fakture/exportFakture", params, function(data) {
			console.log('ispis...')
			
			alert('Exportovana je faktura')
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}