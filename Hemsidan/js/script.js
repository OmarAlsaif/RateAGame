$(document).ready(function(){
    $('.message a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
});

function render(data){
    var html = "<div class='commentBox'><div class='leftPanelImg'><img src='https://via.placeholder.com/100?text='></div><div class='rightPanel'><span>"+data.name+"</span><div class='date'>"+data.date+"</div><p>"+data.body+"</p></div></div>";
    $('#container').append(html);  
}

$(document).ready(function(){  
    
    var comment = [];

        for(var i=0;i<comment.lenght;i++){
            render(comment[i]);
        }

    $('#addComment').click(function(){
        var addObj = {
            "name": $('#name').val(),
            "date": $('#date').val(),
            "body": $('#bodytext').val()
        };
        console.log(addObj);
        comment.push(addObj);
        render(addObj);    
        $('#name').val(' ');
        $('#date').val(' ');
        $('#bodytext').val(' ')

    });
});

$(document).ready(function(){
    $('#menu > ul >li').on('click', function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
    });
});

<<<<<<< HEAD
=======




>>>>>>> e5adb1082aa3dd7163972df0177934c229f2ef9a
