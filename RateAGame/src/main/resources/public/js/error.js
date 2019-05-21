$(document).ready(function() {
	
	// Hämtar popupp
	var modal = document.getElementById("myErrorVote");

	// Hämtar knappen som öppnar popuppen
	var btn = document.getElementById("votebutton");

	// Hämtar <span> elementen som stänger popuppen
	var span = document.getElementsByClassName("close")[0];

	// När användaren klickar på knappen, popuppen öppnas
	btn.onclick = function() {
		modal.style.display = "block";
	}

	// När användaren klickar på <span> (x), Stängs popuppen
	span.onclick = function() {
	  modal.style.display = "none";
	}

	// När användaren klickar var som helst, Stängs popuppen
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}	
});