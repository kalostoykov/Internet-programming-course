$(document).ready(function(){
	"use strict"
	
	$(document).on("click",
			"[data-ajax-fetch]", function(event) {
			var url = $(event.target).attr("data-ajax-fetch");
			$.get(url).then(function(response){
				var targetSelector = $(event.target).attr("data-target");
				var target = $(targetSelector);
				
				target.text(response);
			});
	}
	);
});
