var houses = [];

$(document).ready(function(){
    loadHouses();
    $('#Stark_house').click(function(){
        console.log('Click in stark house');
        var results = searchHouse("Stark");  
        displayData(results);
    });
    $('#Targaryen_house').click(function () {
        console.log('Click in Targaryen house');
        var results = searchHouse("Targaryen");  
        displayData(results);
    });
    $('#Lannister_house').click(function () {
        console.log('Click in Lannister house');
        var results = searchHouse("Lannister");  
        displayData(results);
    });
    $('#Baratheon_house').click(function () {
        console.log('Click in Baratheon house');
        var results = searchHouse("Baratheon");  
        displayData(results);
    });

    
});
function loadHouses(){
    for (let i = 1; i < 445; i++) {
        var URL = `https://www.anapioficeandfire.com/api/houses/${i}`;
        $.get(URL, function (data) {
            houses.push(data);
        });
    }
}
function searchHouse(houseName){
    var results = [];
    for (let i = 0; i < houses.length; i++) {
        
        if (houses[i].name.indexOf(houseName) >0 ){
            results.push(houses[i]);

        }
    }
    return results;
}
function displayData(data){
    console.log(data);
    
    var firstResult = data[0];
    var name = firstResult.name;
    var words = firstResult.words;
    var titles = houseTitles(firstResult);
    if(words == ""){
        words= 'N/A';
    }
    $('#house_name').text(name);
    $('#words_info').text("Words : "+words);
    $('#titles_info').children().remove();
    for (let i = 0; i < titles.length; i++) {
        $('#titles_info').append(`<div> Title : ${titles[i]}</div>`);
        
    }
    

}
function houseTitles(data){
    var titles =[];
    for (let i = 0; i < data.titles.length; i++) {
       titles[i] = data.titles[i];
    }
    return titles;
}