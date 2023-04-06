const buttonEl = document.querySelector('#addToCart');

buttonEl.addEventListener("click", () => {
    const data = {""}

    fetch('http://localhost:8080/api/carts', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: 
    })
})