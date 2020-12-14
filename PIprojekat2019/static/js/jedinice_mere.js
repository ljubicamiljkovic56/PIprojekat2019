//var jedinice = []
//
//$(document).ready(function(){
//	var dataTable = $('#dataTable');
//	
//	function getJedinice(){
//	$.get("http://localhost:8080/api/jedinicemere/all", function(data){
//			console.log(data);
//			
//			jedinice = data;
//			
//			populateTable(jedinice);	
//
//		});
//	}
//	
//	function populateTable(jediniceForTable){
//		
//		console.log('tabela?')
//	
//		for(it of jediniceForTable){
//			dataTable.append(
//				'<tr>' + 
//					'<td>' + it.nazivJediniceMere + '</td>' +
//					'<td>' + it.skraceniNaziv + '</td>' + 
//				'</tr>'
//			)
//		}
//	};
//	
//
//	getJedinice();
//	console.log('dobavljene jedinice mere?');
//});
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
		console.log(getIdOfSelectedEntity());
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntity();
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
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"nazivJediniceMere\">" + data[i].nazivJediniceMere + "</td>"
							+ "<td class=\"skraceniNaziv\">" + data[i].skraceniNaziv + "</td>"
							+ "<td class=\"idCell\">" + data[i].id + "</td>" +
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
	
	var naziv_jedinice_mere = nazivJediniceMereInput.val();
	var skraceni_naziv = skraceniNazivInput.val();
	
	console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere);
	console.log('skraceni_naziv: ' + skraceni_naziv);
	
	var jedinica = {
			"naziv_jedinice_mere": naziv_jedinice_mere,
			"skraceni_naziv": skraceni_naziv
	};
	console.log(jedinica);
	console.log(JSON.stringify(jedinica));
	$.ajax({
			url: "/api/jedinicemere/",
			type: "POST",
			data: JSON.stringify(jedinica),
			contentType: "application/json",
			datatype: "json",
			success: function(data) {
				dobaviJediniceMere();
				$("#nazivJediniceMereInput").val("");
				$("#skraceniNazivInput").val("");
			}
	});
	
//	var nazivJediniceMereInput = $('#nazivJediniceMereInput');
//	var skraceniNazivInput = $('#skraceniNazivInput');
//
//	
//	$('#doAdd').on('click', function(event){
//		var naziv_jedinice_mere = nazivJediniceMereInput.val();
//		var skraceni_naziv = skraceniNazivInput.val();
//		
//		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere)
//		console.log('skraceni_naziv: ' + skraceni_naziv);
//		
//		var params = {
//			'naziv_jedinice_mere': naziv_jedinice_mere,
//			'skraceni_naziv': skraceni_naziv
//		
//			
//		}
//		$.post("http://localhost:8080/api/jedinicemere/dodajJedinicuMere", params, function(data) {
//			console.log('ispis...')
//			console.log(data);
//			
//			alert('Dodata je nova jedinica mere')
//			
//			window.location.href = "jedinice_mere.html";
//		});
//		console.log('slanje poruke');
//		event.preventDefault();
//		return false;
//	});
}


function obrisiJedinicuMere(){
	var id = getIdOfSelectedEntity();
	$.ajax({
    	url: "http://localhost:8080/api/jedinicemere/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviJediniceMere();
        }
	});
}