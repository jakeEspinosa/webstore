const buttonEl = document.querySelector('#checkout');
const h1GreetingEl = document.querySelector('#greeting')
const applesEl = document.querySelector("#item1")
const bananasEl = document.querySelector("#item2")
const watermelonsEl = document.querySelector("#item3")

let myName = "";
let apples = "";
let bananas = "";
let watermelons = "";

async function getFruit() {
    const response = await fetch('http://localhost:8080/carts/' + myName);
    const data = await response.json()
    apples = data.apples;
    bananas = data.bananas;
    watermelons = data.watermelons;
}

async function getUsername() {
    const response = await fetch('http://localhost:8080/who-am-i');
    const data = await response.json();
    myName = await data.username;
    console.log(myName);
}

async function main() {
    await getUsername();
    h1GreetingEl.textContent += myName;

    await getFruit();
    applesEl.textContent += apples;
    bananasEl.textContent += bananas;
    watermelonsEl.textContent += watermelons;
}

main()

// let myName = document.querySelector('#greeting');
// myName.textContent = myName.textContent.slice(7);

