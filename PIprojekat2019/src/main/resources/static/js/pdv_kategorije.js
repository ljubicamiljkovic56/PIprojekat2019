function getPDVKategorije(){
	dobaviPDVKategorije();
	
	$(document).on("click", 'tr', function(event) {
		highlightRow(this);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	$(document).on("click", '#doAdd', function(event){
		dodajPDVKategoriju();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		console.log(getIdOfSelectedEntityKategorija());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniPDVKategoriju();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityKategorija();
		if(name!=null){
			$('#deletePromptText').text("Obrisati: " + name);
			$('#deletePromptModal').modal('show');
		}

	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		obrisiPDVKategoriju();
		$('#deletePromptModal').modal('hide');
	});
	
	
	$(document).on("click", '#search', function(event){
		searchPDVKategorija();
		$("#collapseSearch").collapse('toggle');
	});
	
	$(document).on("click", '#refresh', function(event){
		dobaviPDVKategorije();
	});
	
	$(document).on("click", '#doReset', function(event){
		var nazivSearchInput = $('#nazivKategorijeSearchInput');
		nazivSearchInput.val("");
		$("#collapseSearch").collapse('toggle');
		dobaviPDVKategorije();
	});
}
function dobaviPDVKategorije() {
	var pageNo = 0; 
	var kategorijaPagination = $('#kategorija-page');
	var nmbSelect = $('#nmb-select');
	var pageSize = nmbSelect.find(":selected").text();
	$.ajax({
		url : "http://localhost:8080/api/pdvkategorije/p?pageNo=" + pageNo + "&pageSize=" + pageSize
	}).then(
			function(data, status, request) {
				console.log(data);
				kategorijaPagination.empty();
				$("#dataTableBody").empty();
				console.log(request.getResponseHeader('total'));
				for(var j=0; j<request.getResponseHeader('total'); j++){
                    kategorijaPagination.append(`<li class="page-item  ${pageNo==j? 'active':''}">` +
                        `<${pageNo==j? 'span':'a'} class="page-link" pageNo="${j}">${j+1}</${pageNo==j? 'span':'a'}></li>`);
                }
				for (i = 0; i < data.length; i++) {
					newRow = 
						"<tr>" 
							+ "<td class=\"nazivKategorije\">" + data[i].nazivKategorije + "</td>"
							+ "<td class=\"idKategorije\" style:display:none>" + data[i].idKategorije + "</td>" +
							
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
	    dobaviPDVKategorije();
	});

	kategorijaPagination.on("click","a.page-link", function (event) {
	    event.preventDefault();
	    pageNo = $(this).attr("pageNo");
	    dobaviPDVKategorije();
	});
}

function searchPDVKategorija() {
	var pageNo = 0; 
	var kategorijaPagination = $('#kategorija-page');
	var nmbSelect = $('#nmb-select');
	var pageSize = nmbSelect.find(":selected").text();
	$("#doSearch").on("click", function(event) {
		var nazivSearchInput = $('#nazivKategorijeSearchInput');
		var naziv = nazivSearchInput.val();
		console.log(naziv);
		$.ajax({
			url : "http://localhost:8080/api/pdvkategorije/searchByNazivKategorije?pageNo=" + pageNo + "&pageSize=" + pageSize + "&naziv=" + naziv
		}).then(
				function(data, status, request) {
					console.log(data);
					kategorijaPagination.empty();
					$("#dataTableBody").empty();
					console.log(request.getResponseHeader('total'));
					for(var j=0; j<request.getResponseHeader('total'); j++){
	                    kategorijaPagination.append(`<li class="page-item  ${pageNo==j? 'active':''}">` +
	                        `<${pageNo==j? 'span':'a'} class="page-link" pageNo="${j}">${j+1}</${pageNo==j? 'span':'a'}></li>`);
	                }
					for (i = 0; i < data.length; i++) {
						newRow = 
							"<tr>" 
								+ "<td class=\"nazivKategorije\">" + data[i].nazivKategorije + "</td>"
								+ "<td class=\"idKategorije\" style:display:none>" + data[i].idKategorije + "</td>" +
								
							"</tr>"
						$("#dataTableBody").append(newRow);
					}
				});
		nmbSelect.on('change',function (event) {
			event.preventDefault();
			pageSize = $(this).val();
			dobaviPDVKategorije();
		});

		kategorijaPagination.on("click","a.page-link", function (event) {
			event.preventDefault();
			pageNo = $(this).attr("pageno");
			dobaviPDVKategorije();
		});
	
	});
}
function dodajPDVKategoriju(){
	var nazivKategorijeInput = $('#nazivKategorijeInput');
	
	$('#doAdd').on('click', function(event){
		var naziv_kategorije = nazivKategorijeInput.val();
		
		console.log('naziv_kategorije: ' + naziv_kategorije)
		
		if(naziv_kategorije == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
			'naziv_kategorije': naziv_kategorije
		}
		$.post("http://localhost:8080/api/pdvkategorije/dodajKategoriju", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova pdv kategorija')
			
			dobaviPDVKategorije();
			nazivKategorijeInput.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function izmeniPDVKategoriju(){
	var id = getIdOfSelectedEntityKategorija();
	console.log(id);
	
	var nazivKategorijeIzmeniInput = $('#nazivKategorijeIzmeniInput');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_kategorije = nazivKategorijeIzmeniInput.val();
		
		console.log('naziv_kategorije: ' + naziv_kategorije);
		
		if(naziv_kategorije == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
				'id': id,
				'naziv_kategorije': naziv_kategorije
		}
		$.post("http://localhost:8080/api/pdvkategorije/izmeniKategoriju/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena pdv kategorije');
			
			dobaviPDVKategorije();
			nazivKategorijeIzmeniInput.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
	
}

function obrisiPDVKategoriju(){
	var id = getIdOfSelectedEntityKategorija();
	$.ajax({
    	url: "http://localhost:8080/api/pdvkategorije/obrisiKategoriju/" + id,
    	type: "DELETE",
    	success: function(){
    		dobaviPDVKategorije();
        }
	});
}