$(document).ready(function(){
	
	var naziv_robeInput = $('#naziv_robeInput');
	var novi_nazivInput = $('#novi_nazivInput');
	var opisInput = $('#opisInput');
	var naziv_grupeInput = $('#naziv_grupeInput');
	var naziv_mereInput = $('#naziv_mereInput');


	$('#robaSubmit').on('click', function(event){
		var naziv_robe = naziv_robeInput.val();
		var novi_naziv = novi_nazivInput.val();
		var opis = opisInput.val();
		var naziv_grupe = naziv_grupeInput.val();
		var naziv_mere = naziv_mereInput.val();
		console.log('naziv_robe: ' + naziv_robe)
		console.log('novi_naziv: ' + novi_naziv);
		console.log('opis: ' + opis);
		console.log('naziv_grupe: ' + naziv_grupe);
		console.log('naziv_mere: ' + naziv_mere);
		
		var params = {
			'naziv_robe': naziv_robe,
			'novi_naziv': novi_naziv,
			'opis': opis,
			'naziv_grupe': naziv_grupe,
			'naziv_mere': naziv_mere
		}
		$.post("http://localhost:8080/api/roba/izmeniRobu/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena robe')
			
			window.location.href = "robe.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});