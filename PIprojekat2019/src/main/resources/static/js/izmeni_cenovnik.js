$(document).ready(function(){
	
	var datum_vazenjaInput = $('#datum_vazenjaInput');
	var novi_datumInput = $('#novi_datumInput');


	$('#cenovnikSubmit').on('click', function(event){
		var datum_vazenja = datum_vazenjaInput.val();
		var novi_datum = novi_datumInput.val();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('novi_datum: ' + novi_datum);

		
		var params = {
			'datum_vazenja': datum_vazenja,
			'novi_datum': novi_datum
		}
		$.post("http://localhost:8080/api/cenovnici/izmeniCenovnik/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena cenovnika')
			
			window.location.href = "cenovnici.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});