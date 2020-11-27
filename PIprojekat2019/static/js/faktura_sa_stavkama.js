$(document).ready(function(){
	
	$('#xmlFakturaSubmit').on('click', function(event){
		
		$.get("http://localhost:8080/api/operacije/generateFakturaStavkeFakture/", function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('XML faktura sa stavkama generisana.')
			
			window.location.href = "faktura_sa_stavkama.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});