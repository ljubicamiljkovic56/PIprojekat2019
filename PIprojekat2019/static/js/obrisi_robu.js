$(document).ready(function(){
	var naziv_robeInput = $('#naziv_robeInput');

	
	$('#robaSubmit').on('click', function(event){
		var naziv_robe = naziv_robeInput.val();
		console.log('naziv_robe: ' + naziv_robe);
		
		var params = {
			'naziv_robe': naziv_robe
		}
		$.post("http://localhost:8080/api/roba/obrisiRobu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je roba')
			
			window.location.href = "robe.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});