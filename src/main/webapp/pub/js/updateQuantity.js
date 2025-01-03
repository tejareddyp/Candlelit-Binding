
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

