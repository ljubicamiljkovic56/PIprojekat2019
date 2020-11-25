$(document).ready(function(){
	
	var cenaInput = $('#cenaInput');
	var nova_cenaInput = $('#nova_cenaInput');
	var robaInput = $('#robaInput');
	var datum_vazenjaInput = $('#datum_vazenjaInput');


	$('#stavkaSubmit').on('click', function(event){
		var cena = cenaInput.val();
		var nova_cena = nova_cenaInput.val();
		var roba = robaInput.val();
		var datum_vazenja = datum_vazenjaInput.val();
		console.log('cena: ' + cena)
		console.log('nova_cena: ' + nova_cena);
		console.log('roba: ' + roba);
		console.log('datum_vazenja: ' + datum_vazenja);
		
		var params = {
			'cena': cena,
			'nova_cena': nova_cena,
			'roba': roba,
			'datum_vazenja': datum_vazenja
		}
		$.post("http://localhost:8080/api/stavkecenovnika/izmeniStavkuCenovnika/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena stavke cenovnika')
			
			window.location.href = "stavke_cenovnika.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});