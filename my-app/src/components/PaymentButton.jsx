import { createOrder } from "../services/paymentService";

function PaymentButton() {

  const handlePayment = async () => {

    try {

      const order = await createOrder();

      const options = {

        key: "rzp_test_T601q74nElvQyA",

        amount: order.amount,

        currency: "INR",

        order_id: order.orderId,

        name: "Payment Demo",

        description: "Test Payment",

        handler: function (response) {

          alert("✅ Payment Successful");

          console.log(response);
        },

        modal: {
          ondismiss: function () {
            alert("❌ Payment Cancelled");
          }
        }

      };

      const razorpay = new window.Razorpay(options);

      razorpay.open();

    } catch (error) {

      console.error(error);

      alert("Payment Failed");
    }
  };

  return (
    <button
      className="pay-btn"
      onClick={handlePayment}
    >
      Pay ₹1
    </button>
  );
}

export default PaymentButton;