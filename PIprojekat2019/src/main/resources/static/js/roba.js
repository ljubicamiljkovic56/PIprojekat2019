function getRoba(){
	dobaviRobu();
	dobaviJediniceMere();
	dobaviGrupeRobe();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajRobu();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityRoba());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityRoba();
		if(name!=null){
			$('#deletePromptText').text("Obrisati robu: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiRobu();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviRobu() {
	$.ajax({
		url : "http://localhost:8080/api/roba/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idRobeUsluge)
					newRow = 
					"<tr>" 
						+ "<td class=\"nazivRobeUsluge\">" + data[i].nazivRobeUsluge + "</td>"
						+ "<td class=\"opis\">" + data[i].opis + "</td>"
						+ "<td class=\"roba\">" + data[i].roba + "</td>"
						+ "<td class=\"jedinicaMere\">" + data[i].jedinicaMere.nazivJediniceMere + "</td>"
						+ "<td class=\"grupaRobeUsluga\">" + data[i].grupaRobeUsluga.nazivGrupe + "</td>"
						+ "<td class=\"idRobeUsluge\"  style:display:none>" + data[i].idRobeUsluge + "</td>" +
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

function dobaviJediniceMere() {
	$.ajax({
		url : "http://localhost:8080/api/jedinicemere/all"
	}).then(
		function(data) {
			$("#jedinicaSelect").empty();
			$('#jedinicaSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#jedinicaSelect').append($('<option>', { 
			        value: item.idJediniceMere,
			        text : item.nazivJediniceMere 
			    }));
			});	
		}
	);
}
function dobaviGrupeRobe() {
	$.ajax({
		url : "http://localhost:8080/api/gruperobe/all"
	}).then(
		function(data) {
			$("#grupaSelect").empty();
			$('#grupaSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#grupaSelect').append($('<option>', { 
			        value: item.idGrupe,
			        text : item.nazivGrupe
			    }));
			});	
		}
	);
}
function dodajRobu(){
	var nazivInput = $('#nazivInput');
	var opisInput = $('#opisInput');
	var robaSelect = $('#robaSelect');
	var jedinicaSelect = $('#jedinicaSelect');
	var grupaSelect = $('#grupaSelect');
	
	$('#doAdd').on('click', function(event){
		var naziv_robe = nazivInput.val();
		var opis = opisInput.val();
		var roba = robaSelect.find(":selected").text();;
		var naziv_mere = jedinicaSelect.find(":selected").text();
		var naziv_grupe = grupaSelect.find(":selected").text();
		
		console.log('naziv_robe: ' + naziv_robe)
		console.log('opis: ' + opis);
		console.log('roba: ' + roba);
		console.log('naziv_mere: ' + naziv_mere);
		console.log('naziv_grupe: ' + naziv_grupe);
		
		var params = {
			'naziv_robe': naziv_robe,
			'opis': opis,
			'roba': roba,
			'naziv_mere': naziv_mere,
			'naziv_grupe': naziv_grupe
		}
		$.post("http://localhost:8080/api/roba/dodajRobu", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova roba')
			
			dobaviRobu();
			nazivInput.val("");
			opisInput.val("");
			robaInput.val("");
			jedinicaSelect.val("");
			grupaSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function obrisiRobu(){
	var id = getIdOfSelectedEntityRoba();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/roba/obrisiRobu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviRobu();
        }
	});
}