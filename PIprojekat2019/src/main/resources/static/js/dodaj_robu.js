$(document).ready(function(){
	var naziv_robeInput = $('#naziv_robeInput');
	var opisInput = $('#opisInput');
	var naziv_grupeInput = $('#naziv_grupeInput');
	var naziv_mereInput = $('#naziv_mereInput');

	
	$('#robaSubmit').on('click', function(event){
		var naziv_robe = naziv_robeInput.val();
		var opis = opisInput.val();
		var naziv_grupe = naziv_grupeInput.val();
		var naziv_mere = naziv_mereInput.val();
		
		console.log('naziv_robe: ' + naziv_robe);
		console.log('opis: ' + opis);
		console.log('naziv_grupe: ' + naziv_grupe);
		console.log('naziv_mere: ' + naziv_mere);
		
		
		var params = {
			'naziv_robe': naziv_robe,
			'opis': opis,
			'naziv_grupe': naziv_grupe,
			'naziv_mere': naziv_mere
				
		}
		
		$.post("http://localhost:8080/api/roba/dodajRobu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova roba')
			
			window.location.href = "robe.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});