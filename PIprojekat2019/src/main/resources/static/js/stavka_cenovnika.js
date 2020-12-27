$(document).ready(function() {
	
	var stavka = []
	
	var cenaInput = $('#cenaInput');
	
	 var cenaCell = $('#cenaCell');
	 var cenovnikCell = $('#cenovnikCell');
	 var robaCell = $('#robaCell');

   
 	$('#stavkaSubmit').on('click', function(event){
		var cena = cenaInput.val();

		console.log('cena: ' + cena);
		
		var params = {
			'cena': cena
		}
		$.post("http://localhost:8080/api/stavkecenovnika/pojedinacnaStavkaCenovnika", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Detalji stavke cenovnika...')
			
			stavka = data;
			
			$('#cenaCell').val(stavka.cena);
			$('#cenovnikCell').val(stavka.cenovnik.datumPocetkaVazenja);
			$('#robaCell').val(stavka.robaUsluga.nazivRobeUsluge);
			
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});