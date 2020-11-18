$(document).ready(function(){
	var naziv_jedinice_mereInput = $('#naziv_jedinice_mereInput');

	
	$('#jedinicaSubmit').on('click', function(event){
		var naziv_jedinice_mere = naziv_jedinice_mereInput.val();
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere);
		
		var params = {
			'naziv_jedinice_mere': naziv_jedinice_mere
		}
		$.post("http://localhost:8080/api/jedinicemere/obrisiJedinicuMere", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je jedinica mere')
			
			window.location.href = "jedinice_mere.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});