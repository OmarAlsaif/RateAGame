$(document).ready(function(){
    $('.message a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
});


$(document).ready(function(){
    $('#menu > ul >li').on('click', function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
    });
});

