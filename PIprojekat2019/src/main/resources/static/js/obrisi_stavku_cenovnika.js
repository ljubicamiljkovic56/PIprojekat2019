$(document).ready(function(){
	var cenaInput = $('#cenaInput');

	
	$('#stavkaSubmit').on('click', function(event){
		var cena = cenaInput.val();
		console.log('cena: ' + cena);
		
		var params = {
			'cena': cena
		}
		$.post("http://localhost:8080/api/stavkecenovnika/obrisiStavkuCenovnika", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je stavka cenovnika')
			
			window.location.href = "stavke_cenovnika.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});