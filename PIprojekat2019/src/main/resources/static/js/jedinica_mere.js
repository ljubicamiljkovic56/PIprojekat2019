$(document).ready(function() {
	
	var jedinica = []
	
	var naziv_jedinice_mereInput = $('#naziv_jedinice_mereInput');
	
	 var naziv_jedinice_mereCell = $('#naziv_jedinice_mereCell');
	 var skraceni_nazivCell = $('#skraceni_nazivCell');

   
 	$('#jedinicaSubmit').on('click', function(event){
		var naziv_jedinice_mere = naziv_jedinice_mereInput.val();

		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere);
		
		var params = {
			'naziv_jedinice_mere': naziv_jedinice_mere
		}
		$.post("http://localhost:8080/api/jedinicemere/pojedinacnaJedinicaMere", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji jedinice mere...')
			
			jedinica = data;
			
			$('#naziv_jedinice_mereCell').val(jedinica.nazivJediniceMere);
			$('#skraceni_nazivCell').val(jedinica.skraceniNaziv);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});