$(document).ready(function(){
	var datum_vazenjaInput = $('#datum_vazenjaInput');

	
	$('#cenovnikSubmit').on('click', function(event){
		var datum_vazenja = datum_vazenjaInput.val();
		console.log('datum_vazenja: ' + datum_vazenja);
		
		var params = {
			'datum_vazenja': datum_vazenja
		}
		$.post("http://localhost:8080/api/cenovnici/obrisiCenovnik", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisan je cenovnik')
			
			window.location.href = "cenovnici.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});