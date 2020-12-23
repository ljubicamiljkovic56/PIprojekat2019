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