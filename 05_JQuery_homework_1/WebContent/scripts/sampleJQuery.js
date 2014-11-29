$(document).ready(function(){
	"use strict"
	
	var list = $("#list1");
	console.log(list.children());
	
	//add items in list on button click
	var bAdd = $("#addItem");
	var i = 0;
	document.getElementById("addItem").onclick = function() {
		list.append("<li>new field added #" + i + "</li>");
		i++;
	};
	
	list.find(".pretty");
	
	$("li.pretty").click(function() {
		alert("CLICK!");
	});
	
	$("li.pretty").on("mouseenter", function(){
		console.log("mouse entered the element");
	});
});
