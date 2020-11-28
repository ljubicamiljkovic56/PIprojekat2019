$(document).ready(function(){
	var naziv_preduzecaInput = $('#naziv_preduzecaInput');

	
	$('#preduzeceSubmit').on('click', function(event){
		var naziv_preduzeca = naziv_preduzecaInput.val();
		console.log('naziv_preduzeca: ' + naziv_preduzeca);
		
		var params = {
			'naziv_preduzeca': naziv_preduzeca
		}
		$.post("http://localhost:8080/api/preduzece/obrisiPreduzece", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisano je preduzece')
			
			window.location.href = "preduzeca.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});