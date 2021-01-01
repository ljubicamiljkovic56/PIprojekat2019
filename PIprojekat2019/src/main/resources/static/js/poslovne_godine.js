function getGodine(){
	dobaviGodine();
	dobaviPreduzeca();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajGodinu();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityGodina());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityGodina();
		if(name!=null){
			$('#deletePromptText').text("Obrisati godinu: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiGodinu();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviGodine() {
	$.ajax({
		url : "http://localhost:8080/api/poslovnegodine/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idGodine)
					newRow = 
					"<tr>" 
						+ "<td class=\"godina\">" + data[i].godina + "</td>"
						+ "<td class=\"zakljucena\">" + data[i].zakljucena + "</td>"
						+ "<td class=\"preduzece\">" + data[i].preduzece.nazivPreduzeca + "</td>"
						+ "<td class=\"idGodine\"  style:display:none>" + data[i].idGodine + "</td>" +
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
function dodajGodinu(){
	var godinaInput = $('#godinaInput');
	var zakljucenaSelect = $('#zakljucenaSelect');
	var preduzeceSelect = $('#preduzeceSelect');
	
	$('#doAdd').on('click', function(event){
		var godina = godinaInput.val();
		var zakljucena = zakljucenaSelect.find(":selected").text();
		var preduzece = preduzeceSelect.find(":selected").text();
		
		console.log('godina: ' + godina)
		console.log('zakljucena: ' + zakljucena);
		console.log('preduzece: ' + preduzece);
		
		var params = {
			'godina': godina,
			'zakljucena': zakljucena,
			'preduzece': preduzece
		}
		$.post("http://localhost:8080/api/poslovnegodine/dodajGodinu", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova poslovna godina')
			
			dobaviGodine();
			godinaInput.val("");
			zakljucenaSelect.val("");
			preduzeceSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function obrisiGodinu(){
	var id = getIdOfSelectedEntityGodina();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/poslovnegodine/obrisiGodinu/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviGodine();
        }
	});
}