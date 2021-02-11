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
		
		if(naziv_jedinice_mere == '' || skraceni_naziv == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
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

$.ajax({
	type: 'GET',
	url:'url?pageNum=2',
	success: function(data, textStatus, request){
	alert(request.getResponseHeader('some_header'));
	}
	error: function (request, textStatus, errorThrown) {
	alert(request.getResponseHeader('some_header'));
	}
});