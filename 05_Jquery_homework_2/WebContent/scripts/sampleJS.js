(function() {
	"use strict"
	
	console.log("Hello world", {a: "b"});
	console.error("Hello world", {a: "b"});
	
	alert("Hello world");
	
	var i;
	
	i = 1;
	i++;
	
	if(i === 2) {
		alert("TWO");
	}
	
	
	var array = [];
	array.push("Hello");
	array.push("World");
	
	var o = {
			some: "value"
	};
	
	alert(o.some);
	
	o.some = "value2";
	o.newField = "newField";
	alert(o.newField);
	
	o[o.newField] = "z"
	alert(o.newField);
	var otherObject = {};
	o.subObject = otherObject; 
	o.subObject.id = 1;
	if(o.subObject.id === otherObject.id) {
		alert("TRUE");
	}
	
	var func = function() {
		alert("in func");
	}
	func();
	
	var greeting = function(name) {
		alert("Hello, " + name);
	}
	greeting("World");
	if("false") {
		
	}
	if("") {
		
	}
	
	
})();