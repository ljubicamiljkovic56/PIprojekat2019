$(document).ready(function(){
	var naziv_grupeInput = $('#naziv_grupeInput');
	
	$('#grupaSubmit').on('click', function(event){
		var naziv_grupe = naziv_grupeInput.val();
		
		console.log('naziv_grupe: ' + naziv_grupe)
		
		var params = {
			'naziv_grupe': naziv_grupe
		
		}
		$.post("http://localhost:8080/api/gruperobe/dodajGrupu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Dodata je nova grupa robe')
			
			window.location.href = "grupe_robe.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});