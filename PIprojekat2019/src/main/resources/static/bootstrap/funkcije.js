function highlightRow(row){
	if(!$(row).hasClass("header")){
  		$(".highlighted").removeClass("highlighted");
    	$(row).addClass("highlighted");
    }
}

function getIdOfSelectedEntity(){
	var row = $(".highlighted");
    var id = row.find(".idCell").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntity(){
	var row = $(".highlighted");
    var name = row.find(".name").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getNameOfSelectedEntityJedinica(){
	var row = $(".highlighted");
    var name = row.find(".nazivJediniceMere").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityJedinica(){
	var row = $(".highlighted");
    var id = row.find(".idJediniceMere").html();
    console.log(id);
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getIdOfSelectedEntityKategorija(){
	var row = $(".highlighted");
    var id = row.find(".idKategorije").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityKategorija(){
	var row = $(".highlighted");
    var name = row.find(".nazivKategorije").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityMesto(){
	var row = $(".highlighted");
    var id = row.find(".idMesta").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityMesto(){
	var row = $(".highlighted");
    var name = row.find(".nazivMesta").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityPreduzece(){
	var row = $(".highlighted");
    var id = row.find(".idPreduzeca").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityPreduzece(){
	var row = $(".highlighted");
    var name = row.find(".nazivPreduzeca").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityPartner(){
	var row = $(".highlighted");
    var id = row.find(".idPoslovnogPartnera").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityPartner(){
	var row = $(".highlighted");
    var name = row.find(".nazivPoslovnogPartnera").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}
