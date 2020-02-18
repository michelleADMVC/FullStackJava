$(document).ready(function () {

    $('.hover_img').hover(function () {
        $(this).attr("src", "img/reality.png")
    }, function () {
       console.log( );
            $(this).attr("src", "img/expectation.png")
    });
});