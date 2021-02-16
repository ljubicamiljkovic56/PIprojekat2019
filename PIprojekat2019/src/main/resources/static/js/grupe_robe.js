function getGrupe(){
	dobaviGrupeRobe();
	dobaviPDVKategorije();
	dobaviPDVKategorije2();
	
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
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		izmeniGrupuRobe();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
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
		searchGrupaRobe();
		$("#collapseSearch").collapse('toggle');
	});
	
	$(document).on("click", '#refresh', function(event){
		dobaviGrupeRobe();
	});
	
	$(document).on("click", '#doReset', function(event){
		var nazivSearchInput = $('#nazivSearchInput');
		nazivSearchInput.val("");
		$("#collapseSearch").collapse('toggle');
		dobaviGrupeRobe();
	});
}

function dobaviGrupeRobe() {
	var pageNo = 0; 
	var grupaPagination = $('#grupa-page');
	var nmbSelect = $('#nmb-select');
	var pageSize = nmbSelect.find(":selected").text();
	$.ajax({
		url : "http://localhost:8080/api/gruperobe/p?pageNo=" + pageNo + "&pageSize=" + pageSize
	}).then(
			function(data, status, request) {
				console.log(data);
				grupaPagination.empty();
				$("#dataTableBody").empty();
				console.log(request.getResponseHeader('total'));
				for(var j=0; j<request.getResponseHeader('total'); j++){
                    grupaPagination.append(`<li class="page-item  ${pageNo==j? 'active':''}">` +
                        `<${pageNo==j? 'span':'a'} class="page-link" pageNo="${j}">${j+1}</${pageNo==j? 'span':'a'}></li>`);
                }
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
	
	nmbSelect.on('change',function (event) {
	    event.preventDefault();
	    pageSize = $(this).val();
	    dobaviGrupeRobe();
	});

	grupaPagination.on("click","a.page-link", function (event) {
	    event.preventDefault();
	    pageNo = $(this).attr("pageno");
	    dobaviGrupeRobe();
	});
}

function searchGrupaRobe(){
	var pageNo = 0; 
	var grupaPagination = $('#grupa-page');
	var nmbSelect = $('#nmb-select');
	var pageSize = nmbSelect.find(":selected").text();
	$('#doSearch').on('click', function(event){ 
		var nazivSearchInput = $('#nazivSearchInput');
		var naziv = nazivSearchInput.val();
		console.log(naziv);
		$.ajax({
			url : "http://localhost:8080/api/gruperobe/searchByNaziv?pageNo=" + pageNo + "&pageSize=" + pageSize + "&naziv=" + naziv
		}).then(
				function(data, status, request) {
					console.log(data);
					grupaPagination.empty();
					$("#dataTableBody").empty();
					console.log(request.getResponseHeader('total'));
					for(var j=0; j<request.getResponseHeader('total'); j++){
	                    grupaPagination.append(`<li class="page-item  ${pageNo==j? 'active':''}">` +
	                        `<${pageNo==j? 'span':'a'} class="page-link" pageNo="${j}">${j+1}</${pageNo==j? 'span':'a'}></li>`);
	                }
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
		
		nmbSelect.on('change',function (event) {
		    event.preventDefault();
		    pageSize = $(this).val();
		    dobaviGrupeRobe();
		});

		grupaPagination.on("click","a.page-link", function (event) {
		    event.preventDefault();
		    pageNo = $(this).attr("pageno");
		    dobaviGrupeRobe();
		});
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

function dobaviPDVKategorije2() {
	$.ajax({
		url : "http://localhost:8080/api/pdvkategorije/all"
	}).then(
		function(data) {
			$("#kategorijaIzmeniSelect").empty();
			$('#kategorijaIzmeniSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
			$.each(data, function (i, item) {
			    $('#kategorijaIzmeniSelect').append($('<option>', { 
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
		
		if(naziv_grupe == '' || pdvKategorija == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
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

function izmeniGrupuRobe(){
	var id = getIdOfSelectedEntityGrupa();
	console.log(id);
	
	var nazivIzmeniInput = $('#nazivIzmeniInput');
	var kategorijaIzmeniSelect = $('#kategorijaIzmeniSelect');
	
	$("#doUpdate").on("click", function(event) {
		var naziv_grupe = nazivIzmeniInput.val();
		var pdvKategorija = kategorijaIzmeniSelect.find(":selected").text();
		
		console.log('naziv_grupe: ' + naziv_grupe)
		console.log('pdvKategorija: ' + pdvKategorija);
		
		if(naziv_grupe == '' || pdvKategorija == ''){
			alert("Niste uneli potrebne podatke.");
		}
		
		var params = {
				'id': id,
				'naziv_grupe': naziv_grupe,
				'pdvKategorija': pdvKategorija	
		}
		$.post("http://localhost:8080/api/gruperobe/izmeniGrupu/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena grupe robe');
			
			dobaviGrupeRobe();
			nazivIzmeniInput.val("");
			kategorijaIzmeniSelect.val("");
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