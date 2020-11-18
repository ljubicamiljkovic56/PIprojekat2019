$(document).ready(function(){
	var procenatInput = $('#procenatInput');

	
	$('#pdvstopaSubmit').on('click', function(event){
		var procenat = procenatInput.val();
		console.log('procenat: ' + procenat);
		
		var params = {
			'procenat': procenat
		}
		$.post("http://localhost:8080/api/pdvstope/obrisiPDVStopu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je pdv stopa')
			
			window.location.href = "pdv_stope.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});