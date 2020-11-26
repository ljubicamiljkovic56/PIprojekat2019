$(document).ready(function(){
	var jedinicna_cenaInput = $('#jedinicna_cenaInput');

	
	$('#stavkaSubmit').on('click', function(event){
		var jedinicna_cena = jedinicna_cenaInput.val();
		console.log('jedinicna_cena: ' + jedinicna_cena);
		
		var params = {
			'jedinicna_cena': jedinicna_cena
		}
		$.post("http://localhost:8080/api/stavkefakture/obrisiStavkuFakture", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je stavka fakture')
			
			window.location.href = "stavke_fakture.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});