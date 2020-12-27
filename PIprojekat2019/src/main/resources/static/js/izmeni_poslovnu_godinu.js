$(document).ready(function(){
	
	var godinaInput = $('#godinaInput');
	var godina2Input = $('#godina2Input');

	$('#godinaSubmit').on('click', function(event){
		var godina = godinaInput.val();
		var godina2 = godina2Input.val();
		
		console.log('godina: ' + godina)
		console.log('godina2: ' + godina2);
		
		
		var params = {
			'godina': godina,
			'godina2': godina2
			
		}
		$.post("http://localhost:8080/api/poslovnegodine/izmeniGodinu/", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena poslovne godine')
			
			window.location.href = "poslovne_godine.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});