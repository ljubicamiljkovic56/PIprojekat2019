$(document).ready(function(){
	
	var datum_faktureInput = $('#datum_faktureInput');


	$('#xmlKifSubmit').on('click', function(event){
		var datum_fakture = datum_faktureInput.val();
		
		console.log('datum_fakture: ' + datum_fakture)

		
		var params = {
			'datum_fakture': datum_fakture
		}
		$.post("http://localhost:8080/api/operacije/generateKIF/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Generisanje KIF')
			
			window.location.href = "dnevnik_kif.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});