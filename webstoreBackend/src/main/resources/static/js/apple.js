const buttonEl = document.querySelector('#addToCart');

buttonEl.addEventListener("click", () => {
let data = {"itemId": 1}

    fetch('http://localhost:8080/apples-increment', {
        credentials: 'same-origin',
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
});