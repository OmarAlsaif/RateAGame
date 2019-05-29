

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

