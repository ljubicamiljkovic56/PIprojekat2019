function getPartneri(){
	dobaviPartnere();
	dobaviPreduzeca();
	dobaviMesta();
	dobaviPreduzeca2();
	dobaviMesta2();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajPartnera();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityPartner());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniPartnera();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityPartner();
		if(name!=null){
			$('#deletePromptText').text("Obrisati poslovnog partnera: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiPartnera();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviPartnere() {
	$.ajax({
		url : "http://localhost:8080/api/poslovnipartneri/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idPoslovnogPartnera)
					newRow = 
					"<tr>" 
						+ "<td class=\"idNaseljenogMesta\">" + data[i].naseljenoMesto.nazivMesta + "</td>"
						+ "<td class=\"preduzece\">" + data[i].preduzece.nazivPreduzeca + "</td>"
						+ "<td class=\"nazivPoslovnogPartnera\">" + data[i].nazivPoslovnogPartnera + "</td>"
						+ "<td class=\"adresa\">" + data[i].adresa + "</td>"
						+ "<td class=\"telefon\">" + data[i].telefon + "</td>"
						+ "<td class=\"fax\">" + data[i].fax + "</td>"
						+ "<td class=\"email\">" + data[i].email + "</td>"
						+ "<td class=\"vrstaPartnera\">" + data[i].vrstaPartnera + "</td>"
						+ "<td class=\"idPoslovnogPartnera\"  style:display:none>" + data[i].idPoslovnogPartnera + "</td>" +
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
function dodajPartnera(){
	var nazivInput = $('#nazivInput');
	var adresaInput = $('#adresaInput');
	var telefonInput = $('#telefonInput');
	var faxInput = $('#faxInput');
	var emailInput = $('#emailInput');
	var vrstaPartneraSelect = $('#vrstaPartneraSelect');
	var mestoSelect = $('#mestoSelect');
	var preduzeceSelect = $('#preduzeceSelect');
	
	$('#doAdd').on('click', function(event){
		var naziv_poslovnog_partnera = nazivInput.val();
		var adresa = adresaInput.val();
		var telefon = telefonInput.val();
		var fax = faxInput.val();
		var email = emailInput.val();
		var vrsta_partnera = vrstaPartneraSelect.val();
		var mesto = mestoSelect.val();
		var preduzece = preduzeceSelect.find(":selected").text();
		
		console.log('naziv_poslovnog_partnera: ' + naziv_poslovnog_partnera)
		console.log('adresa: ' + adresa);
		console.log('telefon: ' + telefon);
		console.log('fax: ' + fax);
		console.log('email: ' + email);
		console.log('vrsta_partnera: ' + vrsta_partnera);
		console.log('mesto: ' + mesto);
		console.log('preduzece: ' + preduzece);
		
		var params = {
			'naziv_poslovnog_partnera': naziv_poslovnog_partnera,
			'adresa': adresa,
			'telefon': telefon,
			'fax': fax,
			'email': email,
			'vrsta_partnera': vrsta_partnera,
			'mesto': mesto,
			'preduzece': preduzece
		}
		$.post("http://localhost:8080/api/poslovnipartneri/dodajPoslovnogPartnera", params, function(data) {
			console.log('ispis...')
			
			alert('Dodat je novi poslovni partner')
			
			dobaviPartnere();
			nazivInput.val("");
			adresaInput.val("");
			telefonInput.val("");
			faxInput.val("");
			emailInput.val("");
			vrstaPartneraSelect.val("");
			mestoSelect.val("");
			preduzeceSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function izmeniPartnera() {
	var id = getIdOfSelectedEntityPartner();
	console.log(id);
	
	var nazivIzmeniInput = $('#nazivIzmeniInput');
	var adresaIzmeniInput = $('#adresaIzmeniInput');
	var telefonIzmeniInput = $('#telefonIzmeniInput');
	var faxIzmeniInput = $('#faxIzmeniInput');
	var emailIzmeniInput = $('#emailIzmeniInput');
	var vrstaPartneraIzmeniSelect = $('#vrstaPartneraIzmeniSelect');
	var mestoIzmeniSelect = $('#mestoIzmeniSelect');
	var preduzeceIzmeniSelect = $('#preduzeceIzmeniSelect');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_poslovnog_partnera = nazivIzmeniInput.val();
		var adresa = adresaIzmeniInput.val();
		var telefon = telefonIzmeniInput.val();
		var fax = faxIzmeniInput.val();
		var email = emailIzmeniInput.val();
		var vrsta_partnera = vrstaPartneraIzmeniSelect.val();
		var mesto = mestoIzmeniSelect.val();
		var preduzece = preduzeceIzmeniSelect.find(":selected").text();
		
		console.log('naziv_poslovnog_partnera: ' + naziv_poslovnog_partnera)
		console.log('adresa: ' + adresa);
		console.log('telefon: ' + telefon);
		console.log('fax: ' + fax);
		console.log('email: ' + email);
		console.log('vrsta_partnera: ' + vrsta_partnera);
		console.log('mesto: ' + mesto);
		console.log('preduzece: ' + preduzece);
		
		var params = {
				'id': id,
				'naziv_poslovnog_partnera': naziv_poslovnog_partnera,
				'adresa': adresa,
				'telefon': telefon,
				'fax': fax,
				'email': email,
				'vrsta_partnera': vrsta_partnera,
				'mesto': mesto,
				'preduzece': preduzece
				
		}
		$.post("http://localhost:8080/api/poslovnipartneri/izmeniPoslovnogPartnera/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena poslovnog partnera');
			
			dobaviPartnere();
			nazivIzmeniInput.val("");
			adresaIzmeniInput.val("");
			telefonIzmeniInput.val("");
			faxIzmeniInput.val("");
			emailIzmeniInput.val("");
			vrstaPartneraIzmeniSelect.val("");
			mestoIzmeniSelect.val("");
			preduzeceIzmeniSelect.val("");
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
}

function obrisiPartnera(){
	var id = getIdOfSelectedEntityPartner();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/poslovnipartneri/obrisiPoslovnogPartnera/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviPartnere();
        }
	});
}