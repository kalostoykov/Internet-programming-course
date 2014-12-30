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

	//task_5
	var footer = $("#footer");
	var div = $("<div/>").attr("id", "dynamiccontent");
	footer.prepend(div);

	//task_6
	var input = $("<input/>").attr("id", "textinput");
	div.append(input);

	//task_7
	var button = $("<button/>").attr("id", "addbutton").text("ADD");
	div.append(button);

	//task_8
	var posts = $("<ul/>").attr("id", "posts");
	div.append(posts);

	//task_9
	link.click(function() {
        alert("hello world");
    });

    //task_10
    var switched = false;
    var col1 = $("#col1");
    var col2 = $("#col2");

   	link.click(function() {
   		if(switched == false) {
   			col1.before(col2);
   			switched = true;
   		} else {
   			col2.before(col1);
   			switched = false;
   		}
   	});

   	//task_11
   	function appendToList(list, post) {
		var newElement = $("<li/>");
		newElement.text(post.title);
		list.append(newElement);
	}
	
	function processResponse(response) {
		var i = 0;
		$.each(response, function() {
			appendToList(posts, this);
			if (++i >= 5) {
				return false;
			}
		});
	}
	
	$.ajax("http://jsonplaceholder.typicode.com/posts", {
	  method: "GET"
	}).then(processResponse);

	//task_12, task_13, task_14, task_15, task_16
	button.click(function() {
		if(input.val() === "") {
			alert("Enter some text!");
		} else {
			$.ajax('http://jsonplaceholder.typicode.com/posts', {
  				method: 'POST',
  				data: {
    				title: input.val(),
    				body: 'bar',
    				userId: 1
  				}
			}).then(function(data) {
  				$.ajax('http://jsonplaceholder.typicode.com/posts/' + data.id, {
  					method: 'GET'
				}).then(function(data) {
  					var newElement = $("<li/>");
  					newElement.text(data.title);
  					posts.append(newElement);
  					
  					var deleteButton = $("<button/>");
  					deleteButton.text("X");
  					newElement.append(deleteButton);
  					deleteButton.click(function(){
  						var confirmDialog = confirm("Are you sure you want to delete this post?");
  						if(confirmDialog == true) {
  							$.ajax('http://jsonplaceholder.typicode.com/posts/' + data.id, {
  								method: 'DELETE'
							}).then(function() {
								deleteButton.parent().remove();
								console.log("deleted");	
							});
  						} else {
  							return;
  						}
  					});
				});
			});
		}
	});

	//task_17
	var task17Input = $('<input/>');
	task17Input.insertBefore(posts);

})
