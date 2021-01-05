function getPreduzeca(){
	dobaviPreduzeca();
	dobaviMesta();
	dobaviMesta2();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajPreduzece();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});

	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityPreduzece());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniPreduzece();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityPreduzece();
		if(name!=null){
			$('#deletePromptText').text("Obrisati preduzece: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiPreduzece();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviPreduzeca() {
	$.ajax({
		url : "http://localhost:8080/api/preduzece/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idPreduzeca)
					newRow = 
					"<tr>" 
						+ "<td class=\"idNaseljenogMesta\">" + data[i].naseljenoMesto.nazivMesta + "</td>"
						+ "<td class=\"nazivPreduzeca\">" + data[i].nazivPreduzeca + "</td>"
						+ "<td class=\"adresaPreduzeca\">" + data[i].adresa + "</td>"
						+ "<td class=\"brojTelefona\">" + data[i].brojTelefona + "</td>"
						+ "<td class=\"fax\">" + data[i].fax + "</td>"
						+ "<td class=\"idPreduzeca\"  style:display:none>" + data[i].idPreduzeca + "</td>" +
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

function dobaviMesta() {
	$.ajax({
		url : "http://localhost:8080/api/mesto/all"
	}).then(
		function(data) {
			$("#mestoSelect").empty();
			$('#mestoSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#mestoSelect').append($('<option>', { 
			        value: item.idNaseljenogMesta,
			        text : item.nazivMesta 
			    }));
			});	
		}
	);
}

function dobaviMesta2() {
	$.ajax({
		url : "http://localhost:8080/api/mesto/all"
	}).then(
		function(data) {
			$("#mestoIzmeniSelect").empty();
			$('#mestoIzmeniSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#mestoIzmeniSelect').append($('<option>', { 
			        value: item.idNaseljenogMesta,
			        text : item.nazivMesta 
			    }));
			});	
		}
	);
}
function dodajPreduzece(){
	var nazivInput = $('#nazivInput');
	var adresaInput = $('#adresaInput');
	var brojTelefonaInput = $('#brojTelefonaInput');
	var faxInput = $('#faxInput');
	var mestoSelect = $('#mestoSelect');
	
	$('#doAdd').on('click', function(event){
		var naziv_preduzeca = nazivInput.val();
		var adresa_preduzeca = adresaInput.val();
		var broj_telefona = brojTelefonaInput.val();
		var fax_preduzeca = faxInput.val();
		var naziv_mesta = mestoSelect.val();
		
		console.log('naziv_preduzeca: ' + naziv_preduzeca)
		console.log('adresa_preduzeca: ' + adresa_preduzeca);
		console.log('broj_telefona: ' + broj_telefona);
		console.log('fax_preduzeca: ' + fax_preduzeca);
		console.log('naziv_mesta: ' + naziv_mesta);
		
		var params = {
			'naziv_preduzeca': naziv_preduzeca,
			'adresa_preduzeca': adresa_preduzeca,
			'broj_telefona': broj_telefona,
			'fax_preduzeca': fax_preduzeca,
			'naziv_mesta': naziv_mesta
		}
		$.post("http://localhost:8080/api/preduzece/dodajPreduzece", params, function(data) {
			console.log('ispis...')
			
			alert('Dodato je novo preduzece')
			
			dobaviPreduzeca();
			nazivInput.val("");
			adresaInput.val("");
			brojTelefonaInput.val("");
			faxInput.val("");
			mestoSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function izmeniPreduzece() {
	var id = getIdOfSelectedEntityPreduzece();
	console.log(id);
	
	var nazivIzmeniInput = $('#nazivIzmeniInput');
	var adresaIzmeniInput = $('#adresaIzmeniInput');
	var brojTelefonaIzmeniInput = $('#brojTelefonaIzmeniInput');
	var faxIzmeniInput = $('#faxIzmeniInput');
	var mestoIzmeniSelect = $('#mestoIzmeniSelect');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_preduzeca = nazivIzmeniInput.val();
		var adresa_preduzeca = adresaIzmeniInput.val();
		var broj_telefona = brojTelefonaIzmeniInput.val();
		var fax_preduzeca = faxIzmeniInput.val();
		var naziv_mesta = mestoIzmeniSelect.val();
		
		console.log('naziv_preduzeca: ' + naziv_preduzeca)
		console.log('adresa_preduzeca: ' + adresa_preduzeca);
		console.log('broj_telefona: ' + broj_telefona);
		console.log('fax_preduzeca: ' + fax_preduzeca);
		console.log('naziv_mesta: ' + naziv_mesta);
		
		
		var params = {
				'id': id,
				'naziv_preduzeca': naziv_preduzeca,
				'adresa_preduzeca': adresa_preduzeca,
				'broj_telefona': broj_telefona,
				'fax_preduzeca': fax_preduzeca,
				'naziv_mesta': naziv_mesta
		}
		$.post("http://localhost:8080/api/preduzece/izmeniPreduzece/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena preduzeca');
			
			dobaviPreduzeca();
			nazivIzmeniInput.val("");
			adresaIzmeniInput.val("");
			brojTelefonaIzmeniInput.val("");
			faxIzmeniInput.val("");
			mestoIzmeniSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
}

function obrisiPreduzece(){
	var id = getIdOfSelectedEntityPreduzece();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/preduzece/obrisiPreduzece/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviPreduzeca();
        }
	});
}