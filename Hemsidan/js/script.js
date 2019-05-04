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
// Menyraden, bakgrundseffekt för knapparna 
$(document).ready(function(){
    $('#menu > ul >li').on('click', function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
    });
});

=======
//Rating system
>>>>>>> 0278709694e639d187bebe33ad5e04e49e0f5d22

$(document).ready(function(){
    // Check Radio-box
    $(".rating input:radio").attr("checked", false);

    $('.rating input').click(function () {
        $(".rating span").removeClass('checked');
        $(this).parent().addClass('checked');
    });

    $('input:radio').change(
      function(){
        var userRating = this.value;
    }); 
});



