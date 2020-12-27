$(document).ready(function(){
	var broj_faktureInput = $('#broj_faktureInput');

	
	$('#fakturaSubmit').on('click', function(event){
		var broj_fakture = broj_faktureInput.val();
		console.log('broj_fakture: ' + broj_fakture);
		
		var params = {
			'broj_fakture': broj_fakture
		}
		$.post("http://localhost:8080/api/fakture/obrisiFakturu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je faktura')
			
			window.location.href = "fakture.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});