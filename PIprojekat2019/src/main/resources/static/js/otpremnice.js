function getOtpremnice() {
	dobaviOtpremnice();

	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		//dodajOtpremnicu();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityOtpremnica());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		//izmeniOtpremnicu();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityOtpremnica();
		if(name!=null){
			$('#deletePromptText').text("Obrisati otpremnicu sa rednim brojem: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiOtpremnicu();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviOtpremnice() {
	$.ajax({
		url : "http://localhost:8080/api/otpremnice/all"
	}).then(
			function(data) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"brojOtpremnice\">" + data[i].brojOtpremnice + "</td>"
							+ "<td class=\"kupac\">" + data[i].kupac + "</td>"
							+ "<td class=\"adresaIsporuke\">" + data[i].adresaIsporuke + "</td>"
							+ "<td class=\"datumIsporuke\">" + data[i].datumIsporuke + "</td>"
							+ "<td class=\"prevoznik\">" + data[i].prevoznik + "</td>"
							+ "<td class=\"potpisVozaca\">" + data[i].potpisVozaca + "</td>"
							+ "<td class=\"primioRobu\">" + data[i].primioRobu + "</td>"
							+ "<td class=\"faktura\">" + data[i].faktura.brojFakture + "</td>"
							+ "<td class=\"narudzbenica\">" + data[i].narudzbenica.brojNarudzbenice + "</td>"
							+ "<td class=\"idOtpremnice\"  style:display:none>" + data[i].idOtpremnice + "</td>" 
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

function obrisiOtpremnicu(){
	var id = getIdOfSelectedEntityOtpremnica();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/otpremnice/obrisiOtpremnicu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviOtpremnice();
        }
	});
}