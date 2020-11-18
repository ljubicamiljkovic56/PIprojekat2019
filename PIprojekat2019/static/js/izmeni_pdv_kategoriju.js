$(document).ready(function(){
	
	var naziv_kategorijeInput = $('#naziv_kategorijeInput');
	var novi_nazivInput = $('#novi_nazivInput');


	$('#kategorijaSubmit').on('click', function(event){
		var naziv_kategorije = naziv_kategorijeInput.val();
		var novi_naziv = novi_nazivInput.val();
		console.log('naziv_kategorije: ' + naziv_kategorije)
		console.log('novi_naziv: ' + novi_naziv);
		
		var params = {
			'naziv_kategorije': naziv_kategorije,
			'novi_naziv': novi_naziv
		}
		$.post("http://localhost:8080/api/pdvkategorije/izmeniKategoriju", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena pdv kategorije')
			
			window.location.href = "pdv_kategorije.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});