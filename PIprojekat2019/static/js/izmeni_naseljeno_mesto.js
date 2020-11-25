$(document).ready(function(){
	
	var naziv_mestaInput = $('#naziv_mestaInput');
	var novi_nazivInput = $('#novi_nazivInput');
	var ptt_brojInput = $('#ptt_brojInput');


	$('#mestoSubmit').on('click', function(event){
		var naziv_mesta = naziv_mestaInput.val();
		var novi_naziv = novi_nazivInput.val();
		var ptt_broj = ptt_brojInput.val();
		console.log('naziv_mesta: ' + naziv_mesta)
		console.log('novi_naziv: ' + novi_naziv);
		console.log('ptt_broj: ' + ptt_broj);
		
		var params = {
			'naziv_mesta': naziv_mesta,
			'novi_naziv': novi_naziv,
			'ptt_broj': ptt_broj
		}
		$.post("http://localhost:8080/api/mesto/izmeniMesto/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena naseljenog mesta')
			
			window.location.href = "naseljena_mesta.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});