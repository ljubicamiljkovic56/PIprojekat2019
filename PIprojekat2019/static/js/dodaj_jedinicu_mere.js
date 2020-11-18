$(document).ready(function(){
	var naziv_jedinice_mereInput = $('#naziv_jedinice_mereInput');
	var skraceni_nazivInput = $('#skraceni_nazivInput');

	
	$('#jedinicaSubmit').on('click', function(event){
		var naziv_jedinice_mere = naziv_jedinice_mereInput.val();
		var skraceni_naziv = skraceni_nazivInput.val();
		
		console.log('naziv_jedinice_mere: ' + naziv_jedinice_mere)
		console.log('skraceni_naziv: ' + skraceni_naziv);
		
		var params = {
			'naziv_jedinice_mere': naziv_jedinice_mere,
			'skraceni_naziv': skraceni_naziv
		
			
		}
		$.post("http://localhost:8080/api/jedinicemere/dodajJedinicuMere", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova jedinica mere')
			
			window.location.href = "jedinice_mere.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});