function displayPokemon(num) {
    $(document).ready(function () {
        for (let i = 1; i < num; i++) {
            
            
            var img = "<img class='pokemon_img' src='https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+i+".png'></img>";
            var pokemonCard = "<div class='pokemon_card'>"+img+" </div>";
            var cardContainer = " <div class='card_container'>"+pokemonCard+"</div>"

            $('.pokemon_card_container').append(cardContainer);
        }
   
        
    });
}
displayPokemon(151);
// raw.githubusercontent.com / PokeAPI / sprites / master / sprites / pokemon / shiny / 1.png