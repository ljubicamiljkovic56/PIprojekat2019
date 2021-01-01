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

function getIdOfSelectedEntityPDVStope(){
	var row = $(".highlighted");
    var id = row.find(".idStope").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityPDVStope(){
	var row = $(".highlighted");
    var name = row.find(".datumVazenja").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityGrupa(){
	var row = $(".highlighted");
    var id = row.find(".idGrupe").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityGrupa(){
	var row = $(".highlighted");
    var name = row.find(".nazivGrupe").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityRoba(){
	var row = $(".highlighted");
    var id = row.find(".idRobeUsluge").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityRoba(){
	var row = $(".highlighted");
    var name = row.find(".nazivRobeUsluge").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}

function getIdOfSelectedEntityGodina(){
	var row = $(".highlighted");
    var id = row.find(".idGodine").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}

function getNameOfSelectedEntityGodina(){
	var row = $(".highlighted");
    var name = row.find(".godina").html();
    if(name==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return name;
    }  
}
