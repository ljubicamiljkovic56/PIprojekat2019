$(document).ready(function() {
	
	var grupa = []
	
	var naziv_grupeInput = $('#naziv_grupeInput');
	
	var naziv_grupeCell = $('#naziv_grupeCell');

   
 	$('#grupaSubmit').on('click', function(event){
		var naziv_grupe = naziv_grupeInput.val();

		console.log('naziv_grupe: ' + naziv_grupe);
		
		var params = {
			'naziv_grupe': naziv_grupe
		}
		$.post("http://localhost:8080/api/gruperobe/pojedinacnaGrupa", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji grupe robe...')
			
			grupa = data;
			
			$('#naziv_grupeCell').val(grupa.nazivGrupe);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});