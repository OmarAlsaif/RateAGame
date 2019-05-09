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

// Slideshow Börjar här: 

const slideContainer = document.querySelector('.slide-container');
const containerImages = document.querySelectorAll('.slide-container img'); 

// Knappar
const prevBtn = document.querySelector('#prevBtn');
const nextBtn = document.querySelector('#nextBtn');

// Räknare 
let counter = 1;
const size = containerImages[0].clientWidth;
slideContainer.style.transform = 'translateX(' + (-size * counter ) + 'px';

// Knapptryck 
nextBtn.addEventListener('click',()=>{
    if(counter >= containerImages.length -1) return;
    slideContainer.style.transition = "transform 0.4s ease-in-out";
    counter++;
    slideContainer.style.transform = 'translateX(' + (-size * counter ) + 'px';

});

prevBtn.addEventListener('click',()=>{
    if(counter <= 0) return;
    slideContainer.style.transition = "transform 0.4s ease-in-out";
    counter--;
    slideContainer.style.transform = 'translateX(' + (-size * counter ) + 'px';

});

//Övergångslyssnare 
slideContainer.addEventListener('transitionend', ()=>{
    if (containerImages[counter].id === "lastClone"){
        slideContainer.style.transition = "none";
        counter = containerImages.length -2 ;
        slideContainer.style.transform = 'translateX(' + (-size * counter ) + 'px';
    }

    if (containerImages[counter].id === "firstClone"){
        slideContainer.style.transition = "none";
        counter = containerImages.length - counter;
        slideContainer.style.transform = 'translateX(' + (-size * counter ) + 'px';
    }


});

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


//Time Stamp
var date = new Date();
var DateString = date.toDateString();
var ISOString = date.toISOString();
var timestamp = (date.getTime() / 1000) >> 0;
var temps = [
    '<abbr class="timeago" title="' + ISOString + '">' + ISOString + '</abbr>'];
var elements = document.getElementsByClassName('usage'), j = 0;
function htmlEntities(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}
for (var i in elements) {
    var $this = elements[i];
    if (typeof $this === 'object') {
        console.log(temps[j]);
        $this.innerHTML = (temps[j]) + '<code>' + htmlEntities(temps[j++]) + '</code>';
    }
}

// timeAgo Function
(function timeAgo(selector) {

    var templates = {
        prefix: "",
        suffix: " ago",
        seconds: "less than a minute",
        minute: "about a minute",
        minutes: "%d minutes",
        hour: "about an hour",
        hours: "about %d hours",
        day: "a day",
        days: "%d days",
        month: "about a month",
        months: "%d months",
        year: "about a year",
        years: "%d years"
    };
    var template = function (t, n) {
        return templates[t] && templates[t].replace(/%d/i, Math.abs(Math.round(n)));
    };

    var timer = function (time) {
        if (!time) return;
        time = time.replace(/\.\d+/, ""); // remove milliseconds
        time = time.replace(/-/, "/").replace(/-/, "/");
        time = time.replace(/T/, " ").replace(/Z/, " UTC");
        time = time.replace(/([\+\-]\d\d)\:?(\d\d)/, " $1$2"); // -04:00 -> -0400
        time = new Date(time * 1000 || time);

        var now = new Date();
        var seconds = ((now.getTime() - time) * .001) >> 0;
        var minutes = seconds / 60;
        var hours = minutes / 60;
        var days = hours / 24;
        var years = days / 365;

        return templates.prefix + (
        seconds < 45 && template('seconds', seconds) || seconds < 90 && template('minute', 1) || minutes < 45 && template('minutes', minutes) || minutes < 90 && template('hour', 1) || hours < 24 && template('hours', hours) || hours < 42 && template('day', 1) || days < 30 && template('days', days) || days < 45 && template('month', 1) || days < 365 && template('months', days / 30) || years < 1.5 && template('year', 1) || template('years', years)) + templates.suffix;
    };

    var elements = document.getElementsByClassName('timeago');
    for (var i in elements) {
        var $this = elements[i];
        if (typeof $this === 'object') {
            $this.innerHTML = timer($this.getAttribute('title') || $this.getAttribute('datetime'));
        }
    }
    // update time every minute
    setTimeout(timeAgo, 60000);

})();