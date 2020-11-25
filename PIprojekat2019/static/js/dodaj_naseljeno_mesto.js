$(document).ready(function(){
	var naziv_mestaInput = $('#naziv_mestaInput');
	var ptt_brojInput = $('#ptt_brojInput');

	
	$('#mestoSubmit').on('click', function(event){
		var naziv_mesta = naziv_mestaInput.val();
		var ptt_broj = ptt_brojInput.val();
		
		console.log('naziv_mesta: ' + naziv_mesta);
		console.log('ptt_broj: ' + ptt_broj);
		
		var params = {
			'naziv_mesta': naziv_mesta,
			'ptt_broj': ptt_broj
		
			
		}
		$.post("http://localhost:8080/api/mesto/dodajMesto", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodato je naseljeno mesto')
			
			window.location.href = "naseljena_mesta.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});