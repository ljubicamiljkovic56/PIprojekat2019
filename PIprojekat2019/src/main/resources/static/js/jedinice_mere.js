function getJediniceMere() {
	dobaviJediniceMere();

	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		dodajJedinicuMere();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityJedinica());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniJedinicuMere();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityJedinica();
		if(name!=null){
			$('#deletePromptText').text("Obrisati: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiJedinicuMere();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviJediniceMere() {
	$.ajax({
		url : "http://localhost:8080/api/jedinicemere/all"
	}).then(
			function(data) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"nazivJediniceMere\">" + data[i].nazivJediniceMere + "</td>"
							+ "<td class=\"skraceniNaziv\">" + data[i].skraceniNaziv + "</td>"
							+ "<td class=\"idJediniceMere\"  style:display:none>" + data[i].idJediniceMere + "</td>" 
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
function dodajJedinicuMere(){
	var nazivJediniceMereInput = $('#nazivJediniceMereInput');
	var skraceniNazivInput = $('#skraceniNazivInput');
	
	$('#doAdd').on('click', function(event){
		var naziv_jedinice_mere = nazivJediniceMereInput.val();
		var skraceni_naziv = skraceniNazivInput.val();
		
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere)
		console.log('skraceni_naziv: ' + skraceni_naziv);
		
		if(naziv_jedinice_mere == '' || skraceni_naziv == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
			'naziv_jedinice_mere': naziv_jedinice_mere,
			'skraceni_naziv': skraceni_naziv	
		}
		$.post("http://localhost:8080/api/jedinicemere/dodajJedinicuMere", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova jedinica mere')
			
			dobaviJediniceMere();
			nazivJediniceMereInput.val("");
			skraceniNazivInput.val("");
			//window.location.href = "jedinice_mere.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
	
//	var nazivJediniceMereInput = $('#nazivJediniceMereInput');
//	var skraceniNazivInput = $('#skraceniNazivInput');
//	
//	var naziv_jedinice_mere = nazivJediniceMereInput.val();
//	var skraceni_naziv = skraceniNazivInput.val();
//	
//	console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere);
//	console.log('skraceni_naziv: ' + skraceni_naziv);
//	
//	var jedinica = {
//			naziv_jedinice_mere: $("#nazivJediniceMereInput").val(),
//			skraceni_naziv: $("#skraceniNazivInput").val()
//	};
//	console.log(jedinica);
//	console.log(JSON.stringify(jedinica));
//	$.ajax({
//			url: "http://localhost:8080/api/jedinicemere/saveJedinicaMere",
//			type: "POST",
//			data: JSON.stringify(jedinica),
//			contentType: 'application/json',
//			datatype: 'json',
//			async: false,
//			success: function(data) {
//				dobaviJediniceMere();
//				alert('Dodata je jedinica mere');
//				$("#nazivJediniceMereInput").val("");
//				$("#skraceniNazivInput").val("");
//			}
//	});
}

function izmeniJedinicuMere() {
	var id = getIdOfSelectedEntityJedinica();
	console.log(id);
	
	var nazivJediniceMereIzmeniInput = $('#nazivJediniceMereIzmeniInput');
	var skraceniNazivIzmeniInput = $('#skraceniNazivIzmeniInput');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_jedinice_mere = nazivJediniceMereIzmeniInput.val();
		var skraceni_naziv = skraceniNazivIzmeniInput.val();
		
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere);
		console.log('skraceni_naziv: ' + skraceni_naziv);
		
		var params = {
				'id': id,
				'naziv_jedinice_mere': naziv_jedinice_mere,
				'skraceni_naziv': skraceni_naziv	
		}
		$.post("http://localhost:8080/api/jedinicemere/izmeniJedinicuMere/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena jedinice mere');
			
			dobaviJediniceMere();
			nazivJediniceMereIzmeniInput.val("");
			skraceniNazivIzmeniInput.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
	
	
//	$.ajax({
//    	url: "http://localhost:8080/api/jedinicemere/izmeniJedinicuMere/" + id,
//    	type: "PUT",
//    	data: JSON.stringify(params),
//    	contentType:'application/json',
//    	success: function(){
//    		dobaviJediniceMere();
//        }
//	});
//	
	
}

function obrisiJedinicuMere(){
	var id = getIdOfSelectedEntityJedinica();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/jedinicemere/obrisiJedinicuMere/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviJediniceMere();
        }
	});
}