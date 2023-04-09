const formEl = document.querySelector('#orderLookupForm');

let orderURL = 'http://localhost:8080/orders/';
let orderDetailsArr = [];

async function getOrderDetails() {
    const formData = new FormData(formEl);
    const lookupData = Object.fromEntries(formData);
    const orderNumber = lookupData.orderNumber;
    const response = await fetch(orderURL + orderNumber);

    // process order data
    const data = await response.json()
    orderDetailsArr = Object.entries({"apples": data.applesPurchased, 
                                        "bananas": data.bananasPurchased,
                                        "watermelons": data.watermelonsPurchased});
}

function updatePage() {
    for ([key, value] of orderDetailsArr) {
        const para = document.createElement("p");
        const node = document.createTextNode(key + ": " + value);
        para.appendChild(node);

        const element = document.getElementById("orderDetails");
        element.appendChild(para);
    }
}


async function displayOrderDetails() {
    await getOrderDetails();
    updatePage();

}

formEl.addEventListener('submit', event => {
    event.preventDefault();

    displayOrderDetails()
});