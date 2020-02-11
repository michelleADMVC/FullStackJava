function attach_h3_handlers() {
    $('h3').click(function () { alert('You clicked an H3!'); });
}
$(document).ready(function () {
    attach_h3_handlers();
    $('button').click(function () {
        $('div').append('<h3>I am a dynamically generated H3</h3>');
        attach_h3_handlers();
    });
});