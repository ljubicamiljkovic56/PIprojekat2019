$(document).ready(function(){
	var naziv_poslovnog_partneraInput = $('#naziv_poslovnog_partneraInput');

	
	$('#partnerSubmit').on('click', function(event){
		var naziv_poslovnog_partnera = naziv_poslovnog_partneraInput.val();
		console.log('naziv_poslovnog_partnera: ' + naziv_poslovnog_partnera);
		
		var params = {
			'naziv_poslovnog_partnera': naziv_poslovnog_partnera
		}
		$.post("http://localhost:8080/api/poslovnipartneri/obrisiPoslovnogPartnera", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisan je poslovni partner')
			
			window.location.href = "poslovni_partneri.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});