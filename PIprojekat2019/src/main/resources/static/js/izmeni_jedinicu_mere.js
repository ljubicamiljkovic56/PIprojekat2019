$(document).ready(function(){
	
	var naziv_jedinice_mereInput = $('#naziv_jedinice_mereInput');
	var novi_nazivInput = $('#novi_nazivInput');
	var skraceni_nazivInput = $('#skraceni_nazivInput');


	$('#jedinicaSubmit').on('click', function(event){
		var naziv_jedinice_mere = naziv_jedinice_mereInput.val();
		var novi_naziv = novi_nazivInput.val();
		var skraceni_naziv = skraceni_nazivInput.val();
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere)
		console.log('novi_naziv: ' + novi_naziv);
		console.log('skraceni_naziv: ' + skraceni_naziv);
		
		var params = {
			'naziv_jedinice_mere': naziv_jedinice_mere,
			'novi_naziv': novi_naziv,
			'skraceni_naziv': skraceni_naziv
		}
		$.post("http://localhost:8080/api/jedinicemere/izmeniJedinicuMere/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena jedinice mere')
			
			window.location.href = "jedinice_mere.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});