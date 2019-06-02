
//Effekt vid byta av registeringssidan/inlogg sidan
$(document).ready(function () {
    $('.message a').click(function () {
        $('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
    });
});