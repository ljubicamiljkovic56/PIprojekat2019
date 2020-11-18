$(document).ready(function() {
	
	var kategorija = []
	
	var naziv_kategorijeInput = $('#naziv_kategorijeInput');
	
	 var naziv_kategorijeCell = $('#naziv_kategorijeCell');

   
 	$('#kategorijaSubmit').on('click', function(event){
		var naziv_kategorije = naziv_kategorijeInput.val();

		console.log('naziv_kategorije: ' + naziv_kategorije);
		
		var params = {
			'naziv_kategorije': naziv_kategorije
		}
		$.post("http://localhost:8080/api/pdvkategorije/pojedinacnaKategorija", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji pdv kategorije...')
			
			kategorija = data;
			
			$('#naziv_kategorijeCell').val(kategorija.nazivKategorije);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});