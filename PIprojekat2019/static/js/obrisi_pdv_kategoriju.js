$(document).ready(function(){
	var naziv_kategorijeInput = $('#naziv_kategorijeInput');

	
	$('#kategorijaSubmit').on('click', function(event){
		var naziv_kategorije = naziv_kategorijeInput.val();
		console.log('naziv_kategorije: ' + naziv_kategorije);
		
		var params = {
			'naziv_kategorije': naziv_kategorije
		}
		$.post("http://localhost:8080/api/pdvkategorije/obrisiKategoriju", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je pdv kategorija')
			
			window.location.href = "pdv_kategorije.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});