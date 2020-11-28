$(document).ready(function(){
	var godinaInput = $('#godinaInput');

	
	$('#godinaSubmit').on('click', function(event){
		var godina = godinaInput.val();
		console.log('godina: ' + godina);
		
		var params = {
			'godina': godina
		}
		$.post("http://localhost:8080/api/poslovnegodine/obrisiGodinu", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Obrisana je poslovna godina');
			
			window.location.href = "poslovne_godine.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});