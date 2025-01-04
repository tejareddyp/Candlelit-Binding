
let updateQuantity = (cartId) => {
    cartId = "" + cartId
    let newQuantity = document.getElementById("select-" + cartId).value;

    let currentCart = localStorage.getItem('itemsInCart');

    if (currentCart == null) {
        currentCart = new Map();
    } else {
        currentCart = new Map(JSON.parse(currentCart));
    }
    currentCart.set(cartId, parseInt(newQuantity));

    if (parseInt(newQuantity) === 0) {
        currentCart.delete(cartId);
    }

    localStorage.setItem('itemsInCart', JSON.stringify(Array.from(currentCart.entries())));
    loadCart();
};

let findProductNames = (products, currentCart) => {
    let output = [];

    currentCart.forEach((cartItem) => {
        let prodName = "Product not found";
        let price = "Price not found";
        for (let i = 0; i < products.length; i++) {
            if (products[i].id == cartItem[0]) {
                prodName = products[i].name;
                price = products[i].price;
                break;
            }
        }
        output.push({"id": cartItem[0], "name": prodName, "quantity": cartItem[1], "price": price, "selected": ["", "", "", "", "", "", ""]});
        output[output.length - 1].selected[output[output.length - 1].quantity] = "selected"
    });

    return output;
};