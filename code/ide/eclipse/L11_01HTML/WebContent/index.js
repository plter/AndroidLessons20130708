//
//var a = 0;
//a++;
//
//
//alert(a);


//console.log("Hello HTML5");


//function btnClicked(){
//	console.log("btn clicked");
//}


$('#btnClickMe').click(function(){
//	console.log("Btn Clicked");
	
//	var v = $('#inTxt')[0].value;
	var v = $('#inTxt').val();
	console.log(v);
});


$("div").click(function(){
	$(this).hide(1000);
});