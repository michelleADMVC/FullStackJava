$(document).ready(function () {
    $('.ninja_img').click(function(){
        $(this).hide("linear");
    });
    $('#restore').click(function(){
        $('.ninja_img').show("swing");
    });
});