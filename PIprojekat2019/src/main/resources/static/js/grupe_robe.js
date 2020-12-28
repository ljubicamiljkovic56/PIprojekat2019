function getGrupe(){
	dobaviGrupeRobe();
	dobaviPDVKategorije();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajGrupuRobe();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityGrupa());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityGrupa();
		if(name!=null){
			$('#deletePromptText').text("Obrisati grupu robe: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiGrupuRobe();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviGrupeRobe() {
	$.ajax({
		url : "http://localhost:8080/api/gruperobe/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idGrupe)
					newRow = 
					"<tr>" 
						+ "<td class=\"nazivGrupe\">" + data[i].nazivGrupe + "</td>"
						+ "<td class=\"pdvKategorija\">" + data[i].pdvKategorija.nazivKategorije + "</td>"
						+ "<td class=\"idGrupe\"  style:display:none>" + data[i].idGrupe + "</td>" +
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
function dodajGrupuRobe(){
	var nazivInput = $('#nazivInput');
	var kategorijaSelect = $('#kategorijaSelect');
	
	$('#doAdd').on('click', function(event){
		var naziv_grupe = nazivInput.val();
		var pdvKategorija = kategorijaSelect.find(":selected").text();
		
		console.log('naziv_grupe: ' + naziv_grupe)
		console.log('pdvKategorija: ' + pdvKategorija);
		
		var params = {
			'naziv_grupe': naziv_grupe,
			'pdvKategorija': pdvKategorija
		}
		$.post("http://localhost:8080/api/gruperobe/dodajGrupu", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova grupa robe')
			
			dobaviGrupeRobe();
			nazivInput.val("");
			kategorijaSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function obrisiGrupuRobe(){
	var id = getIdOfSelectedEntityGrupa();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/gruperobe/obrisiGrupu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviGrupeRobe();
        }
	});
}