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