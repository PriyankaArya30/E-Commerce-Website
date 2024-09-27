<!-- Button trigger modal -->

<style>
  .modal-dialog {
    width: 80%; /* Set the width of the modal */
    max-width: 1000px; /* Set the maximum width of the modal */
    height: 80vh; /* Set the height of the modal */
    max-height: 600px; /* Set the maximum height of the modal */
  }
</style>


<!-- Modal -->
<div class="modal fade" id="cart" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title" id="exampleModalLabel">Your Cart</h3>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
          <div class="cart-body"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary checkout-btn" onclick="gotoCheckout()"></a>Checkout</button>
      </div>
    </div>
  </div>
</div>

<div id="toast"></div>