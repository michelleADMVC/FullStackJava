$('#myDiv').children('h3').css('background-color', 'green');
// $('h3, p').click(function () {
//     $(this).parent().append('<h2>HOWDY CODING DOJO!</h2>');
// })
$('h3, p').click(function () {
    $(this).siblings().hide();
})
$('button').click(function () {
    $(this).siblings().children().children("h3").text('Michi michi was here!')
})