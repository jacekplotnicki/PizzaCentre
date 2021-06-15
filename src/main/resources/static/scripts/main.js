function add(id){
console.log("Added to basket id: " + id);
    let obj = {
    "id": id
    }
    let urlString = "/rest/addToBasket?id=" + id
    console.log("urlString: " + urlString);
    $.ajax({
      url: urlString,
      method: "POST",
      data: obj
    }).done(function() {
     console.log("Add to basket")
    });
}