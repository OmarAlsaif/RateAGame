
//Gör menyn till hamburgaremeny vid en viss beredd
var nav = document.getElementById("topNav");
var main = document.getElementById("main");
var menu = document.getElementsByClassName("menuitems");
var close = document.getElementById("closebtn");

nav.style.height = "50px";
main.style.marginTop = "50px";

for (i = 0; i < menu.length; i++) { menu[i].style.marginTop = "100px"; };

close.addEventListener("click", function () {
	var menuIcon = close.children;
	for (i = 0; i < menuIcon.length; i++) {
		menuIcon[i].classList.toggle("active");
	}
});

function navToggle() {
	if (nav.style.height <= "300px") {
		nav.style.height = "50px";
		main.style.marginTop = "50px";
		var i = 0;
		for (i = 0; i < menu.length; i++) {
			menu[i].style.opacity = "0.0";
			menu[i].style.marginTop = "100px";
		};
		document.body.style.backgroundColor = "rgba(243, 102, 67, 0.0)";
	}

	else if (nav.style.height <= "50px") {
		nav.style.height = "300px";
		main.style.marginTop = "275px";
		var i = 0;
		for (i = 0; i < menu.length; i++) {
			menu[i].style.opacity = "1.0";
			menu[i].style.marginTop = "0px";
		};
		document.body.style.backgroundColor = "rgba(243, 102, 67, 0.0)";
	}
};
