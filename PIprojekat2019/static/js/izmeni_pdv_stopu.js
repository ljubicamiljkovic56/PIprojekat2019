$(document).ready(function(){
	
	var procenatInput = $('#procenatInput');
	var novi_procenatInput = $('#novi_procenatInput');
	var datum_vazenjaInput = $('#datum_vazenjaInput');


	$('#pdvstopaSubmit').on('click', function(event){
		var procenat = procenatInput.val();
		var novi_procenat = novi_procenatInput.val();
		var datum_vazenja = datum_vazenjaInput.val();
		console.log('procenat: ' + procenat)
		console.log('novi_procenat: ' + novi_procenat);
		console.log('datum_vazenja: ' + datum_vazenja);
		
		var params = {
			'procenat': procenat,
			'novi_procenat': novi_procenat,
			'datum_vazenja': datum_vazenja
		}
		$.post("http://localhost:8080/api/pdvstope/izmeniPDVStopu/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena pdv stope')
			
			window.location.href = "pdv_stope.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});