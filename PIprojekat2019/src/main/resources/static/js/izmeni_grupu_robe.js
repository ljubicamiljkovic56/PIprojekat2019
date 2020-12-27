$(document).ready(function(){
	
	var naziv_grupeInput = $('#naziv_grupeInput');
	var novi_nazivInput = $('#novi_nazivInput');

	$('#grupaSubmit').on('click', function(event){
		var naziv_grupe = naziv_grupeInput.val();
		var novi_naziv = novi_nazivInput.val();

		console.log('naziv_grupe: ' + naziv_grupe)
		console.log('novi_naziv: ' + novi_naziv);
		
		var params = {
			'naziv_grupe': naziv_grupe,
			'novi_naziv': novi_naziv
		}
		$.post("http://localhost:8080/api/gruperobe/izmeniGrupu/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena grupe robe')
			
			window.location.href = "grupe_robe.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});