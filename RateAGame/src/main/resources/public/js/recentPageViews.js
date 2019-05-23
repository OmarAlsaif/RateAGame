$(document).ready(function() {
	function setCookie(cname, cvalue, exdays) {
	    var d = new Date();
	    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	    var expires = "expires=" + d.toGMTString();
	    document.cookie = cname + '=' + cvalue + ';path="/";' + expires;
	}
	
	function getCookie(cname) {
	    var name = cname + "=";
	    var ca = document.cookie.split(';');
	    for ( var i = 0; i < ca.length; i++) {
	        var c = ca[i].trim();
	        if (c.indexOf(name) == 0)
	            return c.substring(name.length, c.length);
	    }
	    return "";
	}
	
	function checkHistory(targetId) {
	    var history = getCookie("history");
	    var htmlContent = '';

	    if (history != "") {
	        var insert = true;
	        var sp = history.toString().split(",");
	        for ( var i = sp.length - 1; i >= 0; i--) {
	            htmlContent += '<a style="color: white;" class="demo-pricing demo-pricing-1"  href="'
	                    + sp[i]
	                    + '">'
	                    + sp[i].substring(sp[i].lastIndexOf('/') + 1) + '</a><br>';
	            if (sp[i] == document.URL) {
	                insert = false;
	            }
	            document.getElementById(targetId).innerHTML = htmlContent;
	        }
	        if (insert) {
	            sp.push(document.URL);
	        }
	        setCookie("history", sp.toString(), 30);
	    } else {
	        var stack = new Array();
	        stack.push(document.URL);
	        setCookie("history", stack.toString(), 30);
	    }
	}
	
	function clearHistory(targetId) {
	    setCookie("history", "", -1);
	    document.getElementById(targetId).innerHTML = "";
	}
});