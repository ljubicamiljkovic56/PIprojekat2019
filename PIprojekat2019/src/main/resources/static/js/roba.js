$(document).ready(function() {
	
	var roba = []
	
	var naziv_robeInput = $('#naziv_robeInput');
	
	 var naziv_robeCell = $('#naziv_robeCell');
	 var opisCell = $('#opisCell');
	 var robaCell = $('#robaCell');
	 var jedinica_mereCell = $('#jedinica_mereCell');
	 var grupa_robeCell = $('#grupa_robeCell');

   
 	$('#robaSubmit').on('click', function(event){
		var naziv_robe = naziv_robeInput.val();

		console.log('naziv_robe: ' + naziv_robe);
		
		var params = {
			'naziv_robe': naziv_robe
		}
		$.post("http://localhost:8080/api/roba/pojedinacnaRoba", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji robe...')
			
			roba = data;
			
			$('#naziv_robeCell').val(roba.nazivRobeUsluge);
			$('#opisCell').val(roba.opis);
			$('#robaCell').val(roba.roba);
			$('#jedinica_mereCell').val(roba.jedinicaMere.nazivJediniceMere);
			$('#grupa_robeCell').val(roba.grupaRobeUsluga.nazivGrupe);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});