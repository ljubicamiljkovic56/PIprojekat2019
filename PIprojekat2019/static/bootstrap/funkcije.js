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