var houses = [];

$(document).ready(function(){
    loadHouses();
    $('#Stark_house').click(function(){
        console.log('Click in stark house');
        var results = searchHouse("Stark");  
        displayData(results,1);
    });
    $('#Targaryen_house').click(function () {
        console.log('Click in Targaryen house');
        var results = searchHouse("Targaryen");  
        displayData(results,2);
    });
    $('#Lannister_house').click(function () {
        console.log('Click in Lannister house');
        var results = searchHouse("Lannister");  
        displayData(results,3);
    });
    $('#Baratheon_house').click(function () {
        console.log('Click in Baratheon house');
        var results = searchHouse("Baratheon");  
        displayData(results,4);
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
function displayData(data,houseReference){
    console.log(data);
    var houseResult;
    switch (houseReference){
        case 1: houseResult = data[0];
            break;
        case 2: houseResult = data[0];
            break;
        case 3: houseResult = data[2];
            break;
        case 4: houseResult = data[1];
            break;
    }
    console.log(houseResult);
    
    var name = houseResult.name;
    var words = houseResult.words;
    var titles = houseTitles(houseResult);
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