import PaymentButton from "../components/PaymentButton";

function PaymentPage() {
  return (
    <div className="container">
      <div className="card">
        <h1>Payment Gateway</h1>
        <p>Secure payment demo using Razorpay</p>

        <div className="amount">
          Amount: ₹1
        </div>

        <PaymentButton />
      </div>
    </div>
  );
}

export default PaymentPage;