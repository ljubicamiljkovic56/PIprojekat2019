$(document).ready(function(){
	var datum_vazenjaInput = $('#datum_vazenjaInput');
	var procenatInput = $('#procenatInput');

	
	$('#pdvstopaSubmit').on('click', function(event){
		var datum_vazenja = datum_vazenjaInput.val();
		var procenat = procenatInput.val();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('procenat: ' + procenat);
		
		var params = {
			'datum_vazenja': datum_vazenja,
			'procenat': procenat
		
			
		}
		$.post("http://localhost:8080/api/pdvstope/dodajPDVStopu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova pdv stopa')
			
			window.location.href = "pdv_stope.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});