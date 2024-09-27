
    /* global localStorage */

    function add_to_cart(pid, pname, price) {
        let cart = localStorage.getItem("cart");

        if (!cart) {
            // If cart is empty, create a new array with the product
            let products = [{
                productId: pid,
                productName: pname,
                productQuantity: 1,
                productPrice: price
            }];

            localStorage.setItem("cart", JSON.stringify(products));
            console.log("Product added to an empty cart:", products);
            showToast("Product is added to cart")
        } else {
            // If cart is not empty, update the existing cart
            let products = JSON.parse(cart);
            let productIndex = products.findIndex(item => item.productId === pid);

            if (productIndex !== -1) {
                // If product already exists in the cart, update its quantity
                products[productIndex].productQuantity += 1;
                console.log("Product quantity updated:", products);
                showToast("Product Quantity is increased")
            } else {
                // If product doesn't exist in the cart, add it to the cart
                let product = {
                    productId: pid,
                    productName: pname,
                    productQuantity: 1,
                    productPrice: price
                };
                products.push(product);
                console.log("Product added to the existing cart:", products);
                showToast("Product is added to cart")
            }

            localStorage.setItem("cart", JSON.stringify(products));
            console.log("Cart updated:", products);
        }

        updateCart();
    }

    function updateCart() {
        console.log("Updating cart");
        let cartString = localStorage.getItem("cart");

        if (!cartString) {
            console.log("Cart is empty or undefined");
            $(".cart-items").html("(0)");
            $(".cart-body").html("<h6>Cart does not have any item.</h6>");
            $(".checkout-btn").addClass('disabled');
        } else {
            try {
                let cart = JSON.parse(cartString);

                if (!cart || cart.length === 0) {
                    console.log("Cart is empty");
                    $(".cart-items").html("(0)");
                    $(".cart-body").html("<h6>Cart does not have any item.</h6>");
                    $(".checkout-btn").addClass('disabled');
                } else {
                    console.log("Cart contains items:", cart);
                    $(".cart-items").html(`(${cart.length})`);
                    
                    
                let table = `
                    <table class='table'>
                        <thead class='thead-light'>
                            <tr>
                                <th>Item Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total Price</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        
                `;
                        
                        let totalPrice=0;
                        
                cart.forEach((product) => {
                    table += `
                        <tr>
                            <td>${product.productName}</td>
                            <td>${product.productPrice}</td>
                            <td>${product.productQuantity}</td>
                            <td>${product.productQuantity * product.productPrice}</td>
                            <td><button onclick='deleteItemFromCart(${product.productId})' class='btn btn-danger btn-sm'>Remove</button></td>
                        
                        </tr>
                       
                    `;
                         totalPrice+=product.productPrice*product.productQuantity
                });

                table += `
                <tr><td colspan='5'class='text-right font-weight-bold m-5'> Total Amount :${totalPrice} </td></tr>
                        
                    </table>
                `;

                $(".cart-body").html(table);
                
                 $(".checkout-btn").removeClass('disabled');
                     
                     
                    // Update the HTML elements with cart information here
                }
            } catch (error) {
                console.error("Error parsing cart:", error);
            }
        }
    }
    
function deleteItemFromCart(pid) {
    let cartString = localStorage.getItem("cart");

    if (cartString) {
        try {
            let cart = JSON.parse(cartString);

            // Find the index of the item with the specified product ID
            let productIndex = cart.findIndex(item => item.productId === pid);

            if (productIndex !== -1) {
                // If the item is found, remove it from the array
                cart.splice(productIndex, 1);
                console.log(`Item with product ID ${pid} deleted from the cart.`);
                 showToast("Product is removed from cart")
                // Update localStorage with the modified cart
                localStorage.setItem("cart", JSON.stringify(cart));

                // Update the cart display
                updateCart();
            } else {
                console.log(`Item with product ID ${pid} not found in the cart.`);
            }
        } catch (error) {
            console.error("Error parsing cart:", error);
        }
    }
}


    $(document).ready(function () {
       
        updateCart();
    });


    function showToast(content) {
        $("#toast").addClass("display");
        $("#toast").html(content);
        setTimeout(() => {
            $("#toast").removeClass("display");
        },1000);
    }
    
    
    function gotoCheckout(){
        window.location="checkout.jsp"
    }

    
