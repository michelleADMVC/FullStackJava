$(document).ready(function () {
    generate();
    $('.imgConf').click(function(){
        change(catOrNinja($(this).attr('src')),$(this));
        
    });
});

function generate(){
    for (let i = 0; i < 5; i++) {
        var image = "<img id='" + i +"' src='img/"+randomImage()+""+i+".png' class='imgConf'>";
        $('.images').append("<div class='img_container'>" + image + "</div>");

    }   
}
function randomImage(){
    var image;
    var random_boolean = Math.random() >= 0.5;
    if(random_boolean){
        image = "ninja";
    }else{
        image="cat";
    }
    return image;
}
function catOrNinja(src){
    if (src.indexOf('cat')> 0){
        return "cat";
    }else{
        return "ninja";
    }
}
function change(type,jqueryObject){
    if (type == 'cat') {
        console.log("Changing to a ninja");
        var number = jqueryObject.attr('id');
        console.log("cambiando a numero "+number);
        
        jqueryObject.attr("src", "img/ninja"+number+".png");
    }
    if (type == 'ninja') {
        var number = jqueryObject.attr('id');
        console.log("Changing to a cat");
        jqueryObject.attr("src", "img/cat" + number +".png");
    }
}