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
		console.log(getIdOfSelectedEntityJedinica());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniJedinicuMere();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityJedinica();
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
	var pageNo = 0; 
	var cenovnikPagintaion = $('#cenovnik-page');
	var nmbSelect = $('#nmb-select');
	var pageSize = nmbSelect.find(":selected").text();
	$.ajax({
		url : "http://localhost:8080/api/jedinicemere/p?pageNo=" + pageNo + "&pageSize=" + pageSize
	}).then(
			function(data, status, request) {
				console.log(data);
				cenovnikPagintaion.empty();
				$("#dataTableBody").empty();
				console.log(request.getResponseHeader('total'));
				for(var j=0; j<request.getResponseHeader('total'); j++){
                    cenovnikPagintaion.append(`<li class="page-item  ${pageNo==j? 'active':''}">` +
                        `<${pageNo==j? 'span':'a'} class="page-link" pageNo="${j}">${j+1}</${pageNo==j? 'span':'a'}></li>`);
                }
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"nazivJediniceMere\">" + data[i].nazivJediniceMere + "</td>"
							+ "<td class=\"skraceniNaziv\">" + data[i].skraceniNaziv + "</td>"
							+ "<td class=\"idJediniceMere\"  style:display:none>" + data[i].idJediniceMere + "</td>" 
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
	
	nmbSelect.on('change',function (event) {
	    event.preventDefault();
	    pageSize = $(this).val();
	    dobaviJediniceMere();
	});

	cenovnikPagintaion.on("click","a.page-link", function (event) {
	    event.preventDefault();
	    pageNo = $(this).attr("pageno");
	    dobaviJediniceMere();
	});
}


function dodajJedinicuMere(){
	var nazivJediniceMereInput = $('#nazivJediniceMereInput');
	var skraceniNazivInput = $('#skraceniNazivInput');
	
	$('#doAdd').on('click', function(event){
		var naziv_jedinice_mere = nazivJediniceMereInput.val();
		var skraceni_naziv = skraceniNazivInput.val();
		
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere)
		console.log('skraceni_naziv: ' + skraceni_naziv);
		
		if(naziv_jedinice_mere == '' || skraceni_naziv == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
			'naziv_jedinice_mere': naziv_jedinice_mere,
			'skraceni_naziv': skraceni_naziv	
		}
		$.post("http://localhost:8080/api/jedinicemere/dodajJedinicuMere", params, function(data) {
			console.log('ispis...')
			
			alert('Dodata je nova jedinica mere')
			
			dobaviJediniceMere();
			nazivJediniceMereInput.val("");
			skraceniNazivInput.val("");
			//window.location.href = "jedinice_mere.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
	
}

function izmeniJedinicuMere() {
	var id = getIdOfSelectedEntityJedinica();
	console.log(id);
	
	var nazivJediniceMereIzmeniInput = $('#nazivJediniceMereIzmeniInput');
	var skraceniNazivIzmeniInput = $('#skraceniNazivIzmeniInput');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_jedinice_mere = nazivJediniceMereIzmeniInput.val();
		var skraceni_naziv = skraceniNazivIzmeniInput.val();
		
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere);
		console.log('skraceni_naziv: ' + skraceni_naziv);
		
		if(naziv_jedinice_mere == '' || skraceni_naziv == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
				'id': id,
				'naziv_jedinice_mere': naziv_jedinice_mere,
				'skraceni_naziv': skraceni_naziv	
		}
		$.post("http://localhost:8080/api/jedinicemere/izmeniJedinicuMere/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena jedinice mere');
			
			dobaviJediniceMere();
			nazivJediniceMereIzmeniInput.val("");
			skraceniNazivIzmeniInput.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
	
}

function obrisiJedinicuMere(){
	var id = getIdOfSelectedEntityJedinica();
	console.log(id);
	
	$.ajax({
    	url: "http://localhost:8080/api/jedinicemere/obrisiJedinicuMere/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviJediniceMere();
        }
	});
}