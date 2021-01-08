function getNarudzbenice() {
	dobaviNarudzbenice();

	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		//dodajNarudzbenicu();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityNarudzbenica());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		//izmeniNarudzbenicu();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityNarudzbenica();
		if(name!=null){
			$('#deletePromptText').text("Obrisati narudzbenicu sa brojem: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiNarudzbenicu();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviNarudzbenice() {
	$.ajax({
		url : "http://localhost:8080/api/narudzbenica/all"
	}).then(
			function(data) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"brojNarudzbenice\">" + data[i].brojNarudzbenice + "</td>"
							+ "<td class=\"preduzece\">" + data[i].preduzece.nazivPreduzeca + "</td>"
							+ "<td class=\"poslovniPartner\">" + data[i].poslovniPartner.nazivPoslovnogPartnera + "</td>"
							+ "<td class=\"godina\">" + data[i].poslovnaGodina.godina + "</td>"
							+ "<td class=\"idNarudzbenice\"  style:display:none>" + data[i].id + "</td>" 
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

function obrisiNarudzbenicu(){
	var id = getIdOfSelectedEntityNarudzbenica();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/narudzbenica/obrisiNarudzbenicu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviNarudzbenice();
        }
	});
}