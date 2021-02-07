function getMesta() {
	dobaviMesta();

	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		dodajMesto();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityMesto());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniMesto();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityMesto();
		if(name!=null){
			$('#deletePromptText').text("Obrisati: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiMesto();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviMesta() {
	$.ajax({
		url : "http://localhost:8080/api/mesto/all"
	}).then(
			function(data) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"nazivMesta\">" + data[i].nazivMesta + "</td>"
							+ "<td class=\"pttBroj\">" + data[i].pttBroj + "</td>"
							+ "<td class=\"idMesta\"  style:display:none>" + data[i].idMesta + "</td>" +
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
function dodajMesto(){
	var nazivMestaInput = $('#nazivMestaInput');
	var pttBrojInput = $('#pttBrojInput');
	
	$('#doAdd').on('click', function(event){
		var naziv_mesta = nazivMestaInput.val();
		var ptt_broj = pttBrojInput.val();
		
		console.log('naziv_mesta: ' + naziv_mesta);
		console.log('ptt_broj: ' + ptt_broj);
		
		if(naziv_mesta == '' || ptt_broj == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
			'naziv_mesta': naziv_mesta,
			'ptt_broj': ptt_broj	
		}
		$.post("http://localhost:8080/api/mesto/dodajMesto", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je novo mesto');
			
			dobaviMesta();
			nazivMestaInput.val("");
			pttBrojInput.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
	
}

function izmeniMesto() {
	var id = getIdOfSelectedEntityMesto();
	console.log(id);
	
	var nazivMestaIzmeniInput = $('#nazivMestaIzmeniInput');
	var pttBrojIzmeniInput = $('#pttBrojIzmeniInput');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_mesta = nazivMestaIzmeniInput.val();
		var ptt_broj = pttBrojIzmeniInput.val();
		
		console.log('naziv_mesta: ' + naziv_mesta);
		console.log('ptt_broj: ' + ptt_broj);
		
		if(naziv_mesta == '' || ptt_broj == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
				'id': id,
				'naziv_mesta': naziv_mesta,
				'ptt_broj': ptt_broj	
		}
		$.post("http://localhost:8080/api/mesto/izmeniMesto/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena naseljenog mesta');
			
			dobaviMesta();
			nazivMestaInput.val("");
			pttBrojInput.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
	
}

function obrisiMesto(){
	var id = getIdOfSelectedEntityMesto();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/mesto/obrisiMesto/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviMesta();
        }
	});
}