$(document).ready(function(){
	"use strict"
	
	// search for jQuery selectors
	// by element name:
	console.log($("div"));
	
	// by ID - using #
	console.log($("#col2"));
	console.log($("#searchform"));
	
	// by CSS class - using .
	console.log($(".latest"));
	
	// by element name and CSS class:
	console.log($("div.inscreen"));
	
	// by parent (using SPACE) - children of ul that have class pretty:
	console.log($("div .latest > li > a"));
	
	//insert an element before an other
	$("div#header").before($("div#footer"));
	$("#menu-item-2912").before($("#menu-item-2914"));
	$("#col1").before($("#col3"));
});
