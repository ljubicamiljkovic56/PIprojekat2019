$(document).ready(function() {
	
	var mesto = []
	
	var naziv_mestaInput = $('#naziv_mestaInput');
	
	 var naziv_mestaCell = $('#naziv_mestaCell');
	 var ptt_brojCell = $('#ptt_brojCell');

   
 	$('#mestoSubmit').on('click', function(event){
		var naziv_mesta = naziv_mestaInput.val();

		console.log('naziv_mesta: ' + naziv_mesta);
		
		var params = {
			'naziv_mesta': naziv_mesta
		}
		$.post("http://localhost:8080/api/mesto/pojedinacnoMesto", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji naseljenog mesta...')
			
			mesto = data;
			
			$('#naziv_mestaCell').val(mesto.nazivMesta);
			$('#ptt_brojCell').val(mesto.pttBroj);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});