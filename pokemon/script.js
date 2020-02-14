var pokemon_array = [];
class Pokemon {
    constructor(data) {
        this.allData = data;
        this.name = data.name;
        this.id = data.id;
        this.weight = data.weight;
        this.img = data.sprites.front_default;
        this.img_back = data.sprites.back_default;
        this.types = [];
        for (let i = 0; i < data.types.length; i++) {
            this.types.push(data.types[i].type.name);
        }
        this.abilities = [];
        for (let i = 0; i < data.abilities.length; i++) {
            this.abilities.push(data.abilities[i].ability.name);
        }
    }
}
function displayPokemonsFromApi(pokemonNum) {
    for (let i = 0; i < pokemonNum; i++) {
        request(i + 1);
    }
}

function request(index) {
    // RequestDatos---------------------------------------
    var request = new XMLHttpRequest()
    var urlRequest = 'https://pokeapi.co/api/v2/';
    var requestData = "pokemon/" + index + "/";
    var finalURLRequest = urlRequest + requestData;
    // RequestDatos---------------------------------------
    jQueryRequest(finalURLRequest);
}
function jQueryRequest(URL) {
    var data;
    $.get(URL, function (res) {
        var newPokemon = new Pokemon(res);
        displayPokemon(newPokemon);
    }, "json");

}
function displayPokemon(newPokemon) {
    $(document).ready(function () {
        var HTMLcontent = makePokemonCard(newPokemon);
        $('.pokemon_card_container').append(HTMLcontent);
        attach_handlers(newPokemon.id);
        pokemon_array.push(newPokemon);
    });
}
function makePokemonCard(newPokemon) {
    var nameHTML = "<div class='pokemon_data'> <span class='name'>" + maysPrimera(newPokemon.name) + "</span></div>"
    var imgHTML = "<img class='pokemon_img' src='" + newPokemon.img + "' alt='" + newPokemon.name + "'>";
    var datos = imgHTML + nameHTML;
    var pokemonCard = "<div id = '" + newPokemon.id + "'class='pokemon_card'>" + datos + "</div>";
    var card = "<div class='card_container'>" + pokemonCard + "</div>";

    return card;
}
function maysPrimera(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
function attach_handlers(id) {
    var selector = "#" + id + "";
    $(selector).click(function () {
        console.log($(this).attr('id'));
        displayPokemonInfo(searchPokemon(id));
    });
}
function searchPokemon(id) {
    for (let i = 0; i < pokemon_array.length; i++) {
        if (pokemon_array[i].id === id) {
            console.log(pokemon_array[i]);
            return pokemon_array[i];
        }
    }
}
function displayPokemonInfo(pokemon) {
    $('.pokemon_info').show("swing");
    $('.info_weight').text("Peso :"+ pokemon.weight+" Kg");
    $('.info_name').text("Nombre :" +maysPrimera(pokemon.name));
    $('.pokemon_info_img').attr("src", pokemon.img);
    $(".pokemon_info_img").hover(
        function () {
            $('.pokemon_info_img').attr("src", "");
            $('.pokemon_info_img').attr("src", pokemon.img_back);
        }, function () {
            $('.pokemon_info_img').attr("src", pokemon.img);
        }
    );
    displayInfoTypes(pokemon);
    displayInfoAbilities(pokemon);
}
function displayInfoTypes(pokemon){
    $('#info_types_container').text("");
    var htmlTypesTitle = "<span class='info_types info_title_data'> Tipo :</span>"
    $('#info_types_container').append(htmlTypesTitle);
    for (let i = 0; i < pokemon.types.length; i++) {
        var htmlTypes = "<span class='info_types'>" + pokemon.types[i] +"</span>"
        $('#info_types_container').append(htmlTypes);
    }
   
}
function displayInfoAbilities(pokemon) {
    $('#info_abilities_container').text("");
    var htmlAbilitiesTitle = "<span class='info_abilities info_title_data'> Habilidades:</span>"
    $('#info_abilities_container').append(htmlAbilitiesTitle);
    for (let i = 0; i < pokemon.abilities.length; i++) {
        var htmlAbilities = "<span class='info_abilities'>" + pokemon.abilities[i] + "</span>"
        $('#info_abilities_container').append(htmlAbilities);
    }

}
function displayInfoHandler() {
     $('.pokemon_info').hide();
    $('#close_info_button').click(function () {
        $('.pokemon_info').hide();
    });
}
displayInfoHandler();
displayPokemonsFromApi(400);


