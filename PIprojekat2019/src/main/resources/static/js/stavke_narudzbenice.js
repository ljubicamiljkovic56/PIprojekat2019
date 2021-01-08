function getStavkeNarudzbenice() {
	dobaviStavkeNarudzbenice();

	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		//dodajStavkuNarudzbenice();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityStavkaNarudzbenice());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		//izmeniStavkuNarudzbenice();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityStavkaNarudzbenice();
		if(name!=null){
			$('#deletePromptText').text("Obrisati stavku narudzbenice: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiStavkuNarudzbenice();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviStavkeNarudzbenice() {
	$.ajax({
		url : "http://localhost:8080/api/stavkenarudzbenice/all"
	}).then(
			function(data) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"jedinicaMere\">" + data[i].jedinicaMere + "</td>"
							+ "<td class=\"kolicina\">" + data[i].kolicina + "</td>"
							+ "<td class=\"cena\">" + data[i].cena + "</td>"
							+ "<td class=\"iznos\">" + data[i].iznos + "</td>"
							+ "<td class=\"narudzbenica\">" + data[i].narudzbenica.brojNarudzbenice + "</td>"
							+ "<td class=\"robaUsluga\">" + data[i].robaUsluga.nazivRobeUsluge + "</td>"
							+ "<td class=\"idStavkeNarudzbenice\"  style:display:none>" + data[i].id + "</td>" 
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

function obrisiStavkuNarudzbenice(){
	var id = getIdOfSelectedEntityStavkaNarudzbenice();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/stavkenarudzbenice/obrisiStavkuNarudzbenice/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviStavkeNarudzbenice();
        }
	});
}