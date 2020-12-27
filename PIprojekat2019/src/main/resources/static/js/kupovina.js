$(document).ready(function(){
	var nazivInput = $('#nazivInput');
	var cenaInput = $('#cenaInput');
	var opisInput = $('#opisInput');
	var kolicinaInput = $('#kolicinaInput');
	var kupacInput = $('#kupacInput');
	
	$('#kupiSubmit').on('click', function(event){
		var naziv = nazivInput.val();
		var cena = cenaInput.val();
		var opis = opisInput.val();
		var kolicina = kolicinaInput.val();
		var kupac = kupacInput.val();
		
		console.log('naziv: ' + naziv);
		console.log('cena: ' + cena);
		console.log('opis: ' + opis);
		console.log('kolicina: ' + kolicina);
		console.log('kupac: ' + kupac);
		
		
		var params = {
			'naziv': naziv,
			'cena': cena,
			'opis': opis,
			'kolicina': kolicina,
			'kupac': kupac
				
		}
		
		$.post("http://localhost:8080/api/kupljeni_proizvod/kupovina", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Proizvod je kupljen')
			
			window.location.href = "webshop.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});