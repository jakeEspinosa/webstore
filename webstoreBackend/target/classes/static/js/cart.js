const buttonEl = document.querySelector('#checkout');
const h1GreetingEl = document.querySelector('#greeting')
const applesEl = document.querySelector("#item1")
const bananasEl = document.querySelector("#item2")
const watermelonsEl = document.querySelector("#item3")
let cartURL = "";

let myName = "";
let apples = "";
let bananas = "";
let watermelons = "";

async function getUsername() {
    const response = await fetch('http://localhost:8080/who-am-i');
    const data = await response.json();
    myName = await data.username;
    cartURL = 'http://localhost:8080/carts/' + myName
}

async function getFruit() {
    const response = await fetch(cartURL);
    const data = await response.json()
    apples = data.apples;
    bananas = data.bananas;
    watermelons = data.watermelons;
}



async function loadCart() {
    await getUsername();
    h1GreetingEl.textContent += myName;

    await getFruit();
    applesEl.textContent += apples;
    bananasEl.textContent += bananas;
    watermelonsEl.textContent += watermelons;
}

buttonEl.addEventListener('click', event => {
    event.preventDefault();
    data = {'username': myName, 
        'applesPurchased': apples, 
        'bananasPurchased': bananas, 
        'watermelonsPurchased': watermelons}
    
    fetch('http://localhost:8080/orders', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    data = {'username': myName, 
        'applesPurchased': 0, 
        'bananasPurchased': 0, 
        'watermelonsPurchased': 0}

    fetch(cartURL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
});

function main() {
    loadCart();
}

main();