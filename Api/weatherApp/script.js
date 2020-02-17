function getAPIurl(location) {
    var APIKEY = "0e1d43002feaf8ee05811b28f5ede6a9";
    var alternativeURL = `http://api.openweathermap.org/data/2.5/weather?q=${location}&appid=${APIKEY}`
    return alternativeURL;
}
console.log(getAPIurl());
var dataBoxDisplayed = false;
$(document).ready(function () {
    $('form').submit(function () {
        $.get(getAPIurl($('#location').val()), function (res) {
            console.log(res);
            
            display_dataHTML(res);
        }, 'json');

        return false;
    });
});
function display_dataHTML(res){
    var temperature = farenheitToCelsius(res.main.temp);
    var dataHTML = `<div class = 'temperature'>Temperatura :<span id = 'temperature_data'>${Math.trunc(temperature)}</span>°C</div>`
    if (dataBoxDisplayed == false){
        var dataHTML = `<div class = 'card bg-dark p-3 text-light'>${dataHTML}</div>`;
        dataBoxDisplayed = true;
        $('.display_data').append(dataHTML);
    }else{
        $('#temperature_data').text(temperature);
    }
   
    return dataHTML;
}
function farenheitToCelsius(value){
    return (value - 273.15);
}
