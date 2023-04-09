const formEl = document.querySelector('#orderLookupForm');


formEl.addEventListener('submit', event => {
    event.preventDefault();

    const formData = new FormData(formEl);
    const data = Object.fromEntries(formData);
    const orderNumber = data.orderNumber;
    fetch('http://localhost:8080/orders/' + orderNumber)

});