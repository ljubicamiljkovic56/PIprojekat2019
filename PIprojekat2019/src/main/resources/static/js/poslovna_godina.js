$(document).ready(function() {
	
	var godine = []
	
	var godinaInput = $('#godinaInput');
	
	var godinaCell = $('#godinaCell');
	var zakljucenaCell = $('#zakljucenaCell');

   
 	$('#godinaSubmit').on('click', function(event){
		var godina = godinaInput.val();

		console.log('godina: ' + godina);
		
		var params = {
			'godina': godina
		}
		$.post("http://localhost:8080/api/poslovnegodine/pojedinacnaGodina", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji poslovne godine...')
			
			godine = data;
			
			$('#godinaCell').val(godine.godina);
			$('#zakljucenaCell').val(godine.zakljucena);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});