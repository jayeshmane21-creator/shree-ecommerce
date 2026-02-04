let slideIndex = 0;
showSlides();

function showSlides() {
    let slides = document.getElementsByClassName("slide");
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) { slideIndex = 1; }
    slides[slideIndex - 1].style.display = "block";
    setTimeout(showSlides, 5000); // Change image every 5 seconds
}

// Navigation arrows
function plusSlides(n) {
    slideIndex += n;
    let slides = document.getElementsByClassName("slide");
    if (slideIndex > slides.length) { slideIndex = 1; }
    if (slideIndex < 1) { slideIndex = slides.length; }
    
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slides[slideIndex - 1].style.display = "block";
}

function showProducts(category) {
    const productContainer = document.getElementById("product-container");
    const categoryTitle = document.getElementById("category-title");
    const productDisplay = document.getElementById("product-display");

    categoryTitle.innerText = category.replace("-", " ").toUpperCase();
    productContainer.innerHTML = "";

    products[category].forEach(product => {
        let productDiv = document.createElement("div");
        productDiv.classList.add("product");
        productDiv.innerHTML = `
            <img src="${product.img}" alt="${product.name}">
            <h2>${product.name}</h2>
            <p>Price: ${product.price}</p>
        `;
        productContainer.appendChild(productDiv);
    });

    productDisplay.classList.remove("hidden");
}

function addToCart(name, price) {
 fetch("http://localhost:8080/api/cart/add",{
  method:"POST",
  headers:{"Content-Type":"application/json"},
  body:JSON.stringify({productName:name,price:price,quantity:1})
 });
}

function payNow(){
 fetch("http://localhost:8080/api/order/pay",{
  method:"POST",
  headers:{"Content-Type":"application/json"},
  body:JSON.stringify({customerName:"Student",totalAmount:2000})
 }).then(()=>window.location.href="success.html");
}
