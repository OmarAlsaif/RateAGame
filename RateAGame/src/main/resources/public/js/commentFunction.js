function render(data) {
    var html = "<div class='commentBox'><div class='leftPanelImg'><img src='https://via.placeholder.com/100?text='></div><div class='rightPanel'><span>" + data.name + "</span><p>" + data.body + "</p></div></div>";
    $('#container').append(html);
}

$(document).ready(function () {
    var comment = [];
    for (var i = 0; i < comment.lenght; i++) {
        render(comment[i]);
    }

    $('#addComment').click(function () {
        var addObj = {
            "name": $('#name').val(),
            "body": $('#bodytext').val()
        };
        console.log(addObj);
        comment.push(addObj);
        render(addObj);
        $('#name').val(' ');
        $('#bodytext').val(' ')
    });
});