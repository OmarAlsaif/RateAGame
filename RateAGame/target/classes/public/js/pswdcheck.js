$(document).ready(function() {
    var txtPass1 = document.getElementById("txtPass1")
    , txtPass2 = document.getElementById("txtPass2");
  
  function validatePassword(){
    if(txtPass1.value != txtPass2.value) {
      txtPass2.setCustomValidity("Passwords Don't Match");
    } else {
      txtPass2.setCustomValidity('');
    }
  }
  
  txtPass1.onchange = validatePassword;
  txtPass2.onkeyup = validatePassword;

});