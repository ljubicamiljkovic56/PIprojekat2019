$(document).ready(function() {
	
	var pdvstopa = []
	
	var procenatInput = $('#procenatInput');
	
	 var datum_vazenjaCell = $('#datum_vazenjaCell');
	 var procenatCell = $('#procenatCell');

   
 	$('#pdvstopaSubmit').on('click', function(event){
		var procenat = procenatInput.val();

		console.log('procenat: ' + procenat);
		
		var params = {
			'procenat': procenat
		}
		$.post("http://localhost:8080/api/pdvstope/pojedinacnaPDVStopa", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji pdv stope...')
			
			pdvstopa = data;
			
			$('#datum_vazenjaCell').val(pdvstopa.datumVazenja);
			$('#procenatCell').val(pdvstopa.procenat);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});