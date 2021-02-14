function getCenovnici(){
	dobaviCenovnike();
	dobaviPreduzeca();
	dobaviPreduzeca2();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajCenovnik();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityCenovnik());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniCenovnik();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	//brisanje
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityCenovnik();
		if(name!=null){
			$('#deletePromptText').text("Obrisati cenovnik sa datumom: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiCenovnik();
		$('#deletePromptModal').modal('hide');
	});
	
	//kopiranje cenovnika
	$(document).on("click", '#kopirajCenovnik', function(event){
		var name = getNameOfSelectedEntityCenovnik();
		if(name!=null){
			$('#copyPromptText').text("Kopiraj cenovnik sa datumom: " + name);
			$('#copyPromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.copyPromptClose', function(event){
		$('#copyPromptModal').modal('hide');
	});
	
	$(document).on("click", '#doCopy', function(event){
		kopirajCenovnik();
		$('#copyPromptModal').modal('hide');
	});
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviCenovnike() {
	$.ajax({
		url : "http://localhost:8080/api/cenovnici/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idCenovnika)
					newRow = 
					"<tr>" 
						+ "<td class=\"datumPocetkaVazenja\">" + data[i].datumPocetkaVazenja + "</td>"
						+ "<td class=\"preduzece\">" + data[i].preduzece.nazivPreduzeca + "</td>"
						+ "<td class=\"idCenovnika\"  style:display:none>" + data[i].idCenovnika + "</td>" +
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

function dobaviPreduzeca() {
	$.ajax({
		url : "http://localhost:8080/api/preduzece/all"
	}).then(
		function(data) {
			$("#preduzeceSelect").empty();
			$('#preduzeceSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#preduzeceSelect').append($('<option>', { 
			        value: item.idPreduzeca,
			        text : item.nazivPreduzeca
			    }));
			});	
		}
	);
}

function dobaviPreduzeca2() {
	$.ajax({
		url : "http://localhost:8080/api/preduzece/all"
	}).then(
		function(data) {
			$("#preduzeceIzmeniSelect").empty();
			$('#preduzeceIzmeniSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#preduzeceIzmeniSelect').append($('<option>', { 
			        value: item.idPreduzeca,
			        text : item.nazivPreduzeca
			    }));
			});	
		}
	);
}
function dodajCenovnik(){
	var datumInput = $('#datumInput');
	var preduzeceSelect = $('#preduzeceSelect');
	
	$('#doAdd').on('click', function(event){
		var datum_vazenja = datumInput.val();
		var preduzece = preduzeceSelect.find(":selected").text();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('preduzece: ' + preduzece);
		
		if(datum_vazenja == null || preduzece == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
			'datum_vazenja': datum_vazenja,
			'preduzece': preduzece
		}
		$.post("http://localhost:8080/api/cenovnici/dodajCenovnik", params, function(data) {
			console.log('ispis...')
			
			alert('Dodat je novi cenovnik')
			
			dobaviCenovnike();
			datumInput.val("");
			preduzeceSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function izmeniCenovnik() {
	var id = getIdOfSelectedEntityCenovnik();
	console.log(id);
	
	var datumIzmeniInput = $('#datumIzmeniInput');
	var preduzeceIzmeniSelect = $('#preduzeceIzmeniSelect');
	
	$("#doUpdate").on("click", function(event) {
		var datum_vazenja = datumIzmeniInput.val();
		var preduzece = preduzeceIzmeniSelect.find(":selected").text();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('preduzece: ' + preduzece);
		
		var params = {
				'id': id,
				'datum_vazenja': datum_vazenja,
				'preduzece': preduzece
				
		}
		$.post("http://localhost:8080/api/cenovnici/izmeniCenovnik/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena cenovnika');
			
			dobaviCenovnike();
			datumIzmeniInput.val("");
			preduzeceIzmeniSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
}

function obrisiCenovnik(){
	var id = getIdOfSelectedEntityCenovnik();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/cenovnici/obrisiCenovnik/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviCenovnike();
        }
	});
}

function kopirajCenovnik(){
	var id = getIdOfSelectedEntityCenovnik();
	console.log(id);
	var datum_vazenja = getNameOfSelectedEntityCenovnik();
	
	$('#doCopy').on('click', function(event){
		console.log('datum_vazenja: ' + datum_vazenja);
		
		var params = {
				'id':id,
				'datum_vazenja': datum_vazenja
		}
		
		$.post("http://localhost:8080/api/cenovnici/kopirajCenovnik", params, function(data) {
			console.log('ispis...')
			
			alert('Kopiran je cenovnik')
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}