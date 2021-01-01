function getStavkeCenovnika(){
	dobaviStavkeCenovnika();
	dobaviCenovnik();
	dobaviRobu();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		dodajStavkuCenovnika();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityStavkaCenovnika());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityStavkaCenovnika();
		if(name!=null){
			$('#deletePromptText').text("Obrisati stavku cenovnika sa cenom: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiStavkuCenovnika();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		$("#collapseSearch").collapse('toggle');
	});
}

function dobaviStavkeCenovnika() {
	$.ajax({
		url : "http://localhost:8080/api/stavkecenovnika/all"
	}).then(
			function(data) {
				console.log(data);
				
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].idStavke)
					newRow = 
					"<tr>" 
						+ "<td class=\"cena\">" + data[i].cena + "</td>"
						+ "<td class=\"cenovnik\">" + data[i].cenovnik.datumPocetkaVazenja + "</td>"
						+ "<td class=\"roba\">" + data[i].robaUsluga.nazivRobeUsluge + "</td>"
						+ "<td class=\"idStavke\"  style:display:none>" + data[i].idStavke + "</td>" +
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

function dobaviCenovnik() {
	$.ajax({
		url : "http://localhost:8080/api/cenovnici/all"
	}).then(
		function(data) {
			$("#cenovnikSelect").empty();
			$('#cenovnikSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#cenovnikSelect').append($('<option>', { 
			        value: item.idCenovnika,
			        text : item.datumPocetkaVazenja
			    }));
			});	
		}
	);
}

function dobaviRobu() {
	$.ajax({
		url : "http://localhost:8080/api/roba/all"
	}).then(
		function(data) {
			$("#robaSelect").empty();
			$('#robaSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#robaSelect').append($('<option>', { 
			        value: item.idRobeUsluge,
			        text : item.nazivRobeUsluge
			    }));
			});	
		}
	);
}
function dodajStavkuCenovnika(){
	var cenaInput = $('#cenaInput');
	var cenovnikSelect = $('#cenovnikSelect');
	var robaSelect = $('#robaSelect');
	
	$('#doAdd').on('click', function(event){
		var cena = cenaInput.val();
		var cenovnik = cenovnikSelect.find(":selected").text();
		var roba = robaSelect.find(":selected").text();
		
		console.log('cena: ' + cena)
		console.log('cenovnik: ' + cenovnik);
		console.log('roba: ' + roba);

		var params = {
			'cena': cena,
			'cenovnik': cenovnik,
			'roba': roba
		}
		$.post("http://localhost:8080/api/stavkecenovnika/dodajStavkuCenovnika", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova stavka cenovnika')
			
			dobaviStavkeCenovnika();
			cenaInput.val("");
			cenovnikSelect.val("");
			robaSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function obrisiStavkuCenovnika(){
	var id = getIdOfSelectedEntityStavkaCenovnika();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/api/stavkecenovnika/obrisiStavkuCenovnika/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviStavkeCenovnika();
        }
	});
}