$(document).ready(function(){
	
	$('#xmlFakturaSubmit').on('click', function(event){
		
		$.get("http://localhost:8080/api/operacije/generateXML/", function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('XML faktura generisana.')
			
			window.location.href = "fakture.html";
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
});