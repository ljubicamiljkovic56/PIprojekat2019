function getPDVStope(){
	dobaviPDVStope();
	dobaviPDVKategorije();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajPDVStopu();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityPDVStope());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityPDVStope();
		if(name!=null){
			$('#deletePromptText').text("Obrisati pdv stopu: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiPDVStopu();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviPDVStope() {
	$.ajax({
		url : "http://localhost:8080/api/pdvstope/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idStope)
					newRow = 
					"<tr>" 
						+ "<td class=\"pdvKategorija\">" + data[i].pdvKategorija.nazivKategorije + "</td>"
						+ "<td class=\"datumVazenja\">" + data[i].datumVazenja + "</td>"
						+ "<td class=\"procenat\">" + data[i].procenat + "</td>"
						+ "<td class=\"idStope\"  style:display:none>" + data[i].idStope + "</td>" +
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

function dobaviPDVKategorije() {
	$.ajax({
		url : "http://localhost:8080/api/pdvkategorije/all"
	}).then(
		function(data) {
			$("#kategorijaSelect").empty();
			$('#kategorijaSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#kategorijaSelect').append($('<option>', { 
			        value: item.idKategorije,
			        text : item.nazivKategorije 
			    }));
			});	
		}
	);
}
function dodajPDVStopu(){
	var datumInput = $('#datumInput');
	var procenatInput = $('#procenatInput');
	var kategorijaSelect = $('#kategorijaSelect');
	
	$('#doAdd').on('click', function(event){
		var datum_vazenja = datumInput.val();
		var procenat = procenatInput.val();
		var pdvKategorija = kategorijaSelect.find(":selected").text();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('procenat: ' + procenat);
		console.log('pdvKategorija: ' + pdvKategorija);
		
		var params = {
			'datum_vazenja': datum_vazenja,
			'procenat': procenat,
			'pdvKategorija': pdvKategorija
		}
		$.post("http://localhost:8080/api/pdvstope/dodajPDVStopu", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova PDV stopa')
			
			dobaviPDVStope();
			datumInput.val("");
			procenatInput.val("");
			kategorijaSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function obrisiPDVStopu(){
	var id = getIdOfSelectedEntityPDVStope();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/pdvstope/obrisiPDVStopu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviPDVStope();
        }
	});
}