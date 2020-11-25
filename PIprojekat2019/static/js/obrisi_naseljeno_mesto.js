$(document).ready(function(){
	var naziv_mestaInput = $('#naziv_mestaInput');

	
	$('#mestoSubmit').on('click', function(event){
		var naziv_mesta = naziv_mestaInput.val();
		console.log('naziv_mesta: ' + naziv_mesta);
		
		var params = {
			'naziv_mesta': naziv_mesta
		}
		$.post("http://localhost:8080/api/mesto/obrisiMesto", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisano je naseljeno mesto')
			
			window.location.href = "naseljena_mesta.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});