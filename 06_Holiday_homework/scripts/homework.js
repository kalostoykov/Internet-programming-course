$(document).ready(function() {
	"use strict"

	//task_2
	console.log($(".tu").attr("title"));

	//task_3
	console.log($("#col1 > p").text());

	//task_4
	var list = $("#menu-top-level-menu");
	var link = $("<a/>").text("NEW BUTTON");
	link.attr("href", "#");

	var item = $("<li/>");
	item.append(link);
	list.append(item);
})